package interviewPrep.hackerrank.algorithm.sorting;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by jwlee1 on 2017. 8. 8..
 */
public class BigSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String[] unsorted = new String[n];
		for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
			unsorted[unsorted_i] = in.next();
		}
		// your code goes here
		Stream.of(unsorted).sorted((s, o) -> bigSort(s, o)).forEach(System.out::println);
	}

	private static int bigSort(String s, String o){
		if(s.length() > o.length()){
			return 1;
		} else if(s.length() < o.length()){
			return -1;
		} else {
			BigInteger i = new BigInteger(s);
			BigInteger j = new BigInteger(o);
			return i.compareTo(j);
		}
	}
}
