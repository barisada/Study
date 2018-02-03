package books.effective_java.ch2.item5;

import org.springframework.util.StopWatch;

public class UnnecessaryObject {

    public static void main(String[] args) {
        String s = new String("unnecessary objects");
        System.out.println(s);

        StopWatch sw = new StopWatch();
        sw.start("autounboxing object sum");
        Long sum = 0L;
        for(long i = 0; i < Integer.MAX_VALUE; i++){
            sum += 1;
        }
        sw.stop();
        sw.start("just sum");
        long sum2 = 0L;
        for(long i = 0; i < Integer.MAX_VALUE; i++){
            sum2 += 1;
        }
        sw.stop();
        System.out.println(sw.prettyPrint());


    }
}
