package books.effective_java.ch4.item17;

import java.util.Date;

public final class Sub extends Super{
    private final Date date;

    Sub(){
        date = new Date();
    }

    @Override
    public void overrideMe() {
        System.out.println(date);
    }
}
