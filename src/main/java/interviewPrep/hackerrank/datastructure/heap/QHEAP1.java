package interviewPrep.hackerrank.datastructure.heap;

import books.clrs.ch6.MinPriorityQueue;

import java.util.Scanner;

/**
 * Created by jw on 2017-08-03.
 */
public class QHEAP1 {
    public static void main(String[] args) {
        MinPriorityQueue pq = new MinPriorityQueue();
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i = 0; i < size; i++){
            int input = sc.nextInt();
            switch(input){
                case 1 : pq.insert(sc.nextInt());break;
                case 2 : pq.remove(sc.nextInt());break;
                case 3 : System.out.println(pq.min()); break;
            }
        }
        sc.close();
    }
}
