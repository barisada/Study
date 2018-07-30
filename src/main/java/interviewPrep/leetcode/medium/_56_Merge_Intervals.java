package interviewPrep.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class _56_Merge_Intervals {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return new ArrayList<>();

        intervals.sort((i1, i2) -> {
            if (Integer.compare(i1.start, i2.start) == 0) {
                return Integer.compare(i1.end, i2.end);
            } else {
                return Integer.compare(i1.start, i2.start);
            }
        });

        List<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));
        for(int i = 1; i < intervals.size(); i++){
            Interval last = list.get(list.size()  -1);
            Interval current = intervals.get(i);
            if(last.end >= current.start){
                int end = last.end > current.end ? last.end : current.end;
                list.set(list.size() - 1, new Interval(last.start, end));
            } else {
                list.add(intervals.get(i));
            }
        }

        return list;
    }
}
