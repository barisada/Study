package ourstudy.kakaotest.answers;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jw on 2017-07-02.
 */
public class SecondProblem {
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();

        List<MyInteger> list = new ArrayList<>();
        for(int i = 0; i < total; i++){
            int input = sc.nextInt();
            MyInteger temp = new MyInteger(input, Integer.toBinaryString(input).replaceAll("0", "").length());
            list.add(temp);
        }
        sc.close();

        list.sort(MyInteger::compareTo);
        System.out.println(list.stream().map(my -> my.dec).collect(Collectors.toList()));
    }

}

class MyInteger implements Comparable<MyInteger>{
    int dec;
    int binaryCardinarity;
    public MyInteger(int decimal, int bc){
        dec = decimal;
        binaryCardinarity = bc;
    }

    public static int compare(MyInteger mi1, MyInteger mi2) {
        if(mi1.binaryCardinarity > mi2.binaryCardinarity){
            return 1;
        } else if (mi1.binaryCardinarity < mi2.binaryCardinarity){
            return -1;
        } else {
            if(mi1.dec > mi2.dec){
                return 1;
            } else if(mi1.dec < mi2.dec){
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public String toString() {
        return "MyInteger{" +
                "dec=" + dec +
                ", binaryCardinarity=" + binaryCardinarity +
                '}';
    }

    @Override
    public int compareTo(MyInteger o) {
        return compare(this, o);
    }
}
