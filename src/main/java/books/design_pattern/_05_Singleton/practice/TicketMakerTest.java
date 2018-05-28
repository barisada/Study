package books.design_pattern._05_Singleton.practice;

import java.util.stream.IntStream;

/**
 * Created on 2018-05-28.
 */
public class TicketMakerTest {
    public static void main(String[] args) {
        TicketMaker tm = TicketMaker.getInstance();
        TicketMaker tm2 = TicketMaker.getInstance();
        TicketMaker tm3 = TicketMaker.getInstance();

        IntStream.range(0, 10).parallel().forEach(i -> {
            System.out.println("[" + i + "] : getNextTicketNumber = " + tm.getNextTicketNumber());
            System.out.println("[" + i + "] : getNextTicketNumber = " + tm2.getNextTicketNumber());
            System.out.println("[" + i + "] : getNextTicketNumber = " + tm3.getNextTicketNumber());
        });
    }
}
