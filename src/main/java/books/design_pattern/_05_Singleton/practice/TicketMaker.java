package books.design_pattern._05_Singleton.practice;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2018-05-28.
 */
public class TicketMaker {
    private static TicketMaker ticketMaker = new TicketMaker();
    private AtomicInteger ticket = new AtomicInteger(1000);

    private TicketMaker(){}

    public static TicketMaker getInstance(){
        return ticketMaker;
    }

    public int getNextTicketNumber(){
        return ticket.getAndIncrement();
    }
}
