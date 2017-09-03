package ourstudy.clrs.ch15;

import java.util.Arrays;

/**
 * Created by jwlee1 on 2017. 9. 3..
 */
public class RodCutting {

	public int memoizedCutRod(int[]p, int n){
		int[] r = new int[p.length];
		Arrays.fill(r, Integer.MIN_VALUE);
		return memoizedCutRodAux(p, n, r);
	}

	private int memoizedCutRodAux(int[] p, int n, int[] r) {
		if(r[n] >= 0){
			return r[n];
		}
		if(n == 0){
			return 0;
		}

		int q = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++){
			q = Math.max(q, (p[i] + memoizedCutRodAux(p, n - i, r)));
		}
		r[n] = q;

		return r[n];
	}

	public int bottomUpCutRod(int[] p, int n){
		if( n == 0){
			return 0;
		}
		int[] r = new int[p.length];
		Arrays.fill(r, 0);


		for(int i = 1; i <= n; i++) {
			int q = 0;
			for (int j = 0; j <= i; j++) {
				q = Math.max(q, (p[j] + r[i - j]));
			}
			//System.out.println(i + " : " + q);
			r[i] = q;
		}

		return r[n];
	}
}
