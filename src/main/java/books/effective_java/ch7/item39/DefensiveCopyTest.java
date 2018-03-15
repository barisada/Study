package books.effective_java.ch7.item39;

import java.util.Date;

public class DefensiveCopyTest {
    public static void main(String[] args) {
        Date start = new Date();
        Date end = new Date();
        DefensiveCopyExample ex = new DefensiveCopyExample(start, end);

        start.setYear(99);
        System.out.println(ex.getStart().getYear() + " vs " + start.getYear());

        end.setYear(1);
        System.out.println(ex.getEnd().getYear() + " vs " + end.getYear());

        ex.getStart().setYear(99);
        System.out.println(99 + " vs " + ex.getStart().getYear());

        ex.getEnd().setYear(23);
        System.out.println(23 + " vs " + ex.getEnd().getYear());

        //expect error
        System.out.println(start.compareTo(end));
        DefensiveCopyExample ex2 = new DefensiveCopyExample(start, end);
    }
}
