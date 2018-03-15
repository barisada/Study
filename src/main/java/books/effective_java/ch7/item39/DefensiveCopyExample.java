package books.effective_java.ch7.item39;

import java.util.Date;

public final class DefensiveCopyExample {
    private final Date start;
    private final Date end;

    public DefensiveCopyExample(Date start, Date end){
        if(start.compareTo(end) > 0){
            throw new IllegalArgumentException(start + " after " + end);
        }
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }
}
