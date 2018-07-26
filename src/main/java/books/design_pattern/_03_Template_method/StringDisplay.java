package books.design_pattern._03_Template_method;

/**
 * Created on 2018-05-24.
 */
public class StringDisplay extends AbstractDisplay{
    private String str;

    public StringDisplay(String str) {
        this.str = str;
    }

    @Override
    public void open() {
        printLine();
    }

    @Override
    public void print() {
        System.out.println("|" + str + "|");
    }

    @Override
    public void close() {
        printLine();
    }

    private void printLine(){
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for(int i = 0; i < str.getBytes().length; i++){
            sb.append("-");
        }
        sb.append("+");
        System.out.println(sb.toString());
    }
}
