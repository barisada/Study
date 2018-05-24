package books.design_pattern._02_adapter.adaptee;

/**
 * Created on 2018-05-16.
 */
public class Banner {
    private String str;

    public Banner(String str) {
        this.str = str;
    }

    public void showWIthParen(){
        System.out.println( "(" + str + ")");
    }

    public void showWithAster(){
        System.out.println( "*" + str + "*");
    }
}
