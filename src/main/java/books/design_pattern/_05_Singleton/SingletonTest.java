package books.design_pattern._05_Singleton;

/**
 * Created on 2018-05-28.
 */
public class SingletonTest {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        if(singleton1 == singleton2){
            System.out.println("it is singleton");
        } else{
            System.out.println("it is not singleton");
        }

    }
}
