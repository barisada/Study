package books.design_pattern._03_Template_method;

/**
 * Created on 2018-05-24.
 */
public class CharDisplay extends AbstractDisplay {
    private char c;

    public CharDisplay(char c) {
        this.c = c;
    }

    @Override
    public void open() {
        System.out.print("<<");
    }

    @Override
    public void print() {
        System.out.print(c);
    }

    @Override
    public void close() {
        System.out.println(">>");
    }
}
