package books.design_pattern._05_Singleton;

/**
 * Created on 2018-05-28.
 */
public class Singleton {
    private static Singleton singleton = new Singleton();

    private Singleton(){
        System.out.println(getClass().getSimpleName() + " instance has been created.");
    }

    public static Singleton getInstance(){
        return singleton;
    }
}
