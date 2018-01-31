package books.clrs.ch15;

import org.springframework.util.StopWatch;

/**
 * Created by jwlee1 on 2017. 9. 3..
 */
public class RodCuttingClient {
	public static void main(String[] args) {
		RodCutting rc = new RodCutting();
		int[] p = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		int max = 0;
		StopWatch sw = new StopWatch();

		sw.start();
		for(int i = 0; i < 10000000; i++){
			max = rc.bottomUpCutRod(p, 10);
		}
		sw.stop();
		System.out.println(max);

		sw.start();
		for(int i = 0; i < 10000000; i++) {
			max = rc.memoizedCutRod(p, 10);
		}
		sw.stop();
		System.out.println(max);

		System.out.println(sw.prettyPrint());


	}
}
