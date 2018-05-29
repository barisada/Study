package books.design_pattern._07_Builder.practice;

import books.design_pattern._07_Builder.Director;

import javax.swing.*;

/**
 * Created on 2018-05-30.
 */
public class FrameBuilderTest {
    public static void main(String[] args) {
        FrameBuilder frameBuilder = new FrameBuilder();
        Director director = new Director(frameBuilder);
        director.construct();

        JFrame frame = frameBuilder.getFrame();
        frame.setVisible(true);
    }
}
