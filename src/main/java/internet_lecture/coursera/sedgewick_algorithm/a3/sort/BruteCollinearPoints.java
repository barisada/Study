package internet_lecture.coursera.sedgewick_algorithm.a3.sort;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-10-30.
 */
public class BruteCollinearPoints {
    Map<Double, List<LineSegment>> map;
    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points){
        if (points == null || points.length < 2) {
            throw new IllegalArgumentException ("point is null or less than 1");
        }

        Map<Double, List<LineSegment>> map = new HashMap<>();
        for(int i = 0; i < points.length - 1; i++){
            for(int j = i + 1; j < points.length; j++){
                double slope = points[i].slopeTo(points[j]);
                if(Objects.isNull(map.get(slope))){
                    List<LineSegment> list = new ArrayList<>();
                    list.add(new LineSegment(points[i], points[j]));
                    map.put(slope, list);
                } else {
                    List<LineSegment> list = map.get(slope);
                    list.add(new LineSegment(points[i], points[j]));
                }
            }
        }
        this.map = map;
    }

    // the number of line segments
    public int numberOfSegments(){
        return map.size();
    }

    // the line segments
    public LineSegment[] segments(){
        List<LineSegment> list = map.keySet().stream().map(key -> map.get(key))
                .filter(segments -> segments.size() > 2)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        return list.toArray(new LineSegment[list.size()]);
    }
}
