package books.effective_java.ch9.item60;

import java.util.ConcurrentModificationException;

/**
 * Created on 2018-04-06.
 */
public class UseStandardExceptionTest {
    public static void main(String[] args) {
        try {
            UseStandardExceptionExample.illegalArgumentException(0);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }

        try{
            UseStandardExceptionExample.illegalStateException(new SomeObject());
        } catch (IllegalStateException e){
            e.printStackTrace();
        }
        try{
            UseStandardExceptionExample.nullPointerException(null);
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        try{
            UseStandardExceptionExample.indexOutOfBoundsException(1);
        } catch(IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        try{
            UseStandardExceptionExample.concurrentModificationException();
        } catch (ConcurrentModificationException e){
            e.printStackTrace();
        }

        try{
            UseStandardExceptionExample.unsupportedoperationException();
        } catch (UnsupportedOperationException e){
            e.printStackTrace();
        }





    }
}
