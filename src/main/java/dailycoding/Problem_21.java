package dailycoding;

import java.util.*;

/**
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping),
 * find the minimum number of rooms required.
 *
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 *
 * leetcode #253
 */
public class Problem_21 {
    public static void main(String[] args) {
        Problem_21 test = new Problem_21();
        List<Interval> list1 = new ArrayList<>();
        list1.add(test.createinterval(30, 75));
        list1.add(test.createinterval(0, 50));
        list1.add(test.createinterval(60, 150));

        System.out.println("should be 2 : " + test.minimumMeetingRoom(list1));

        // [(30, 75), (0, 50), (10, 20), (5, 20), (60, 150)]
        list1.add(test.createinterval(10, 20));
        list1.add(test.createinterval(5, 20));
        System.out.println("should be 3 : " + test.minimumMeetingRoom(list1));

        List<Interval> list2 = new ArrayList<>();
        list2.add(test.createinterval(0, 30));
        list2.add(test.createinterval(5, 10));
        list2.add(test.createinterval(15, 20));

        System.out.println("should be 2 : " + test.minimumMeetingRoom(list2));

        List<Interval> list3 = new ArrayList<>();
        list3.add(test.createinterval(1,4));
        list3.add(test.createinterval(5,6));
        list3.add(test.createinterval(8,9));
        list3.add(test.createinterval(2,6));

        System.out.println("should be 2 : " + test.minimumMeetingRoom(list3));
    }

    public int minimumMeetingRoom(List<Interval> intervals){
        if(intervals.size() == 0) return 0;
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        int max = 0;
        Queue<Interval> queue = new PriorityQueue<>(Comparator.comparingInt(interval -> interval.end));
        for(Interval interval : intervals){
            while(!queue.isEmpty() && queue.peek().end <= interval.start){
                queue.poll();
            }
            queue.add(interval);
            max = Math.max(max, queue.size());
        }
        return max;
    }

    public Interval createinterval(int start, int end){
        return new Interval(start, end);
    }
    class Interval{
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
