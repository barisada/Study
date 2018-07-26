package books.design_pattern._03_Template_method;

/**
 * Created on 2018-05-24.
 */
public abstract class AbstractDisplay {
    public abstract void open();
    public abstract void print();
    public abstract void close();

    /**
     * this is Template method.
     */
    public final void display(){
        open();
        for(int i = 0; i < 5; i++){
            print();
        }
        close();
    }

}
