package books.effective_java.ch9.item59;

/**
 * Created on 2018-04-05.
 */
public class AvoidUnnecessaryCheckedExceptionExample {
    public static void doNotDoThis(Object args){
        SampleObject obj = new SampleObject();

        try {
            obj.action(args);
        } catch (TheCheckedException e) {
            System.out.println("do not do like this");
            e.printStackTrace();
        }
    }

    public static void betterDoLikeThis(Object args){
        SampleObject2 obj = new SampleObject2();
        if(obj.actionPermitted(args)) {
            obj.action(args);
        } else {
            throw new NullPointerException();
        }

    }
}

class SampleObject{
    public void action(Object args) throws TheCheckedException {
        if(args == null) throw new TheCheckedException();
    }

    public boolean actionPermitted(Object args){
        return args != null;
    }
}
class SampleObject2{
    public void action(Object args){
        // do something.
    }

    public boolean actionPermitted(Object args){
        return args != null;
    }
}


class TheCheckedException extends Exception{

}
