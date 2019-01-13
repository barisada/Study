package books.effective_java.ch2.item6;

import java.util.stream.IntStream;

public class MemoryLeakStackTest {

    public static void main(String[] args) throws InterruptedException {
        long beforeFreeMem = Runtime.getRuntime().freeMemory();
        MemoryLeakStack mls1 = new MemoryLeakStack();
        IntStream.of(10_000_000).forEach( i -> mls1.push(new Object()));
        IntStream.of(10_000_000).forEach( i -> mls1.pop());
        System.gc();
        Thread.sleep(1000);
        long afterFreeMem = Runtime.getRuntime().freeMemory();
        System.out.println("memory leak example ");
        System.out.println("before free memory: " + beforeFreeMem);
        System.out.println("after free memory: " + afterFreeMem);
        System.out.println("difference : " + (afterFreeMem - beforeFreeMem));

        System.out.println("===============================");

        beforeFreeMem = Runtime.getRuntime().freeMemory();
        MemoryLeakStack mls2 = new MemoryLeakStack();
        IntStream.of(10_000_000).forEach( i -> mls2.push(new Object()));
        IntStream.of(10_000_000).forEach( i -> mls2.pop());
        System.gc();
        Thread.sleep(1);
        afterFreeMem = Runtime.getRuntime().freeMemory();
        System.out.println("prevent memory leak example ");
        System.out.println("before free memory: " + beforeFreeMem);
        System.out.println("after free memory: " + afterFreeMem);
        System.out.println("difference : " + (afterFreeMem - beforeFreeMem));




    }
}
