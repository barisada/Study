package books.design_pattern._07_Builder.practice;

import books.design_pattern._07_Builder.Builder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

/**
 * Created on 2018-05-30.
 */
public class FrameBuilder implements Builder, ActionListener{
    private JFrame frame = new JFrame();
    private Box box = new Box(BoxLayout.Y_AXIS);

    @Override
    public Builder makeTitle(String title) {
        frame.setTitle(title);
        return this;
    }

    @Override
    public Builder makeString(String str) {
        box.add(new JLabel(str));
        return this;
    }

    @Override
    public Builder makeItems(List<String> list) {
        Box innerBox = new Box(BoxLayout.Y_AXIS);
        for(String item : list){
            JButton button = new JButton(item);
            innerBox.add(button);
            button.addActionListener(this);
        }
        box.add(innerBox);
        return this;
    }

    @Override
    public void close() {
        frame.getContentPane().add(box);
        frame.pack();
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public JFrame getFrame(){
        return frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
