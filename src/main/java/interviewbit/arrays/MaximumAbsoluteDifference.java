package interviewbit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jwlee1 on 2017. 8. 20..
 *
 You are given an array of N integers, A1, A2 ,…, AN. Return maximum value of f(i, j) for all 1 ≤ i, j ≤ N.
 f(i, j) is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.

 For example,

 A=[1, 3, -1]

 f(1, 1) = f(2, 2) = f(3, 3) = 0
 f(1, 2) = f(2, 1) = |1 - 3| + |1 - 2| = 3
 f(1, 3) = f(3, 1) = |1 - (-1)| + |1 - 3| = 4
 f(2, 3) = f(3, 2) = |3 - (-1)| + |2 - 3| = 5

 So, we return 5.
 */
public class MaximumAbsoluteDifference {

	/*
		f(i, j) = |A[i] - A[j]| + |i - j| can be written in 4 ways (Since we are looking at max value,
		we don’t even care if the value becomes negative as long as we are also covering the max value in some way).

		(A[i] + i) - (A[j] + j)
		-(A[i] - i) + (A[j] - j)
		(A[i] - i) - (A[j] - j)
		(-A[i] - i) + (A[j] + j) = -(A[i] + i) + (A[j] + j)
		Note that case 1 and 4 are equivalent and so are case 2 and 3.

		We can construct two arrays with values: A[i] + i and A[i] - i.
		Then, for above 2 cases, we find the maximum value possible. For that,
		we just have to store minimum and maximum values of
		expressions A[i] + i and A[i] - i for all i.
	 */
	public int maxArr(ArrayList<Integer> A) {
		List<Integer> list1  = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		for(int i = 0; i < A.size(); i++){
			list1.add(A.get(i) + i);
		}
		for(int i = 0; i < A.size(); i++){
			list2.add(A.get(i) - i);
		}
		int max1 = list1.stream().max(Integer::compareTo).get();
		int min1 = list1.stream().min(Integer::compareTo).get();
		int sum1 = max1 - min1;
		int max2 = list2.stream().max(Integer::compareTo).get();
		int min2 = list2.stream().min(Integer::compareTo).get();
		int sum2 = max2 - min2;
		return sum1 > sum2 ? sum1 : sum2;
	}

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(19, 65, 42, 66, -44, 45, -42, 17, -52, -59 );
		MaximumAbsoluteDifference mad = new MaximumAbsoluteDifference();
		int max = mad.maxArr(new ArrayList<>(list));
		System.out.println(max);
	}
}
