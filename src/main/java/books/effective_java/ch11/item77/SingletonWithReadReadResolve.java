package books.effective_java.ch11.item77;

import java.io.Serializable;

/**
 * Created on 2018-05-12.
 */
public class SingletonWithReadReadResolve implements Serializable{
    public static final SingletonWithReadReadResolve INSTANCE = new SingletonWithReadReadResolve();

    private SingletonWithReadReadResolve(){}

    public void doSomething(){
        System.out.println(this.getClass().getSimpleName() + " : did something");
    }

    //return real INSTANCE
    private Object readResolve(){
        return INSTANCE;
    }
}
