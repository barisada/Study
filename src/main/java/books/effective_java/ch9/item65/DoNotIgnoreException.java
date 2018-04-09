package books.effective_java.ch9.item65;

/**
 * Created on 2018-04-09.
 */
public class DoNotIgnoreException {

    public static void main(String[] args) {

        //empty catch...
        try{
            //do something
        } catch (Exception e){
        }

        System.err.println("Item 65: Don’t ignore exceptions");
    }
}
