package hackerrank.algorithm.recursion;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by jwlee1 on 2017. 9. 17..
 */
public class RepetitiveKSums {
	public static BigInteger[][] memo = new BigInteger[3000][3000];

	public static BigInteger choose(BigInteger n, BigInteger k) {

		if (n.intValue() == 0 && k.intValue() > 0) {
			return BigInteger.ZERO;
		} else if (k.intValue() == 0 && n.intValue() >= 0) {
			return BigInteger.ONE;
		} else if (memo[n.intValue()][k.intValue()] != null) {
			return memo[n.intValue()][k.intValue()];
		} else {
			memo[n.intValue()][k.intValue()] = choose(n.subtract(BigInteger.ONE), k.subtract(BigInteger.ONE)).add(choose(n.subtract(BigInteger.ONE), k));
		}
		return memo[n.intValue()][k.intValue()];

	}
	private static void findSequence(int n, int k, int l, List<BigInteger> list, List<BigInteger> result){
		while(result.size() < n){
			result.add(list.get(0).divide(new BigInteger(String.valueOf(k))));
			System.out.println("list : " + list);
			int del = choose(new BigInteger(String.valueOf(k)), new BigInteger(String.valueOf(l))).intValue();
			System.out.println(k+"c"+l + " = " + del + " vs " + list.size());
			for(int i = 0; i < del && list.size() > 0; i++){
				list.remove(0);
			}
			System.out.println("size  :" + list.size());
			findSequence(n, k, l - 1, list, result);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		IntStream.range(0, cases).forEach( c -> {
			int n = sc.nextInt();
			int k = sc.nextInt();
			sc.nextLine();
			String line = sc.nextLine();
			List<BigInteger> list = Arrays.asList(line.split(" ")).stream().map(BigInteger::new).collect(Collectors.toList());

			List<BigInteger> result = new ArrayList<>(n);
			findSequence(n, k, n, list, result);
			System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
		});
	}
}
