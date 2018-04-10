package books.effective_java.ch10.item66;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created on 2018-04-10.
 */
public class SharedMutableDataExample {
    private boolean stopRequest;
    private volatile boolean  volatiledStopRequest;

    private volatile int serialNumber = 0;
    private AtomicLong atomicSerialNumber = new AtomicLong(0);

    public void livenessFailure() throws InterruptedException {
        Thread t = new Thread(() -> {
            int i = 0;
            while(!stopRequest){
                i++;
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequest = true;
    }

    public void fixedLivenessFailure() throws InterruptedException {
        Thread t = new Thread(() -> {
            int i = 0;
            while(!volatiledStopRequest){
                i++;
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(1);
        volatiledStopRequest = true;
    }

    public int serialNumberSafetyFailure(){
        return serialNumber++;
    }

    public long fixedSerialNumberSafetyFailure(){
        return atomicSerialNumber.incrementAndGet();
    }
}
