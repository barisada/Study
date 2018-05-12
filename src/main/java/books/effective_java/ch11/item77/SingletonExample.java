package books.effective_java.ch11.item77;

import java.io.Serializable;

/**
 * Created on 2018-05-12.
 */
public class SingletonExample implements Serializable{
    public static final SingletonExample INSTANCE = new SingletonExample();

    private SingletonExample(){}

    public void doSomething(){
        System.out.println("do something method");
    }
}
