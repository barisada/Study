package books.effective_java.ch10.item72;

/**
 * Created on 2018-04-27.
 */
public class AwfulCountDownLatchExample {
    private int count;

    public AwfulCountDownLatchExample(int count){
        if(count < 0){
            throw new IllegalArgumentException(count + " < 0");
        }
        this.count = count;
    }

    public void await(){
        while(true){
            synchronized (this){
                if(count == 0) return;
            }
        }
    }

    public synchronized void countDown(){
        if(count != 0){
            count--;
        }
    }


}
