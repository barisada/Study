package books.effective_java.ch8.item51;

import org.springframework.util.StopWatch;

/**
 * Created on 2018. 4. 1..
 */
public class StringConcatenationTest {
	public static void main(String[] args) {
		StringConcatenationExample ex = new StringConcatenationExample();
		StopWatch sw = new StopWatch("string concatenation");

		sw.start("Bad");
		String bad = ex.badConcat();
		sw.stop();

		sw.start("Good");
		String good = ex.goodConcat();
		sw.stop();

		System.out.println("same? " + bad.equals(good));
		System.out.println(sw.prettyPrint());

	}
}
