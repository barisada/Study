package books.effective_java.ch10.item71;

import org.springframework.util.Assert;

/**
 * Created on 2018. 4. 22..
 */
public class LazyInitializationTest {
	public static void main(String[] args) {
		LazyInitializationExample ex = new LazyInitializationExample();

		//to see detail, use debug mode
		Object lazyInit = ex.getLazyInitField();
		Object doubleCheckLazyInit = ex.getDoubleCheckIdiomField();
		Object staticLazyInit = LazyInitializationExample.getStaticLazyInitField();

		Assert.notNull(lazyInit, "lazyInit cannot be null");
		Assert.notNull(doubleCheckLazyInit, "doubleCheckLazyInit cannot be null");
		Assert.notNull(staticLazyInit, "staticLazyInit cannot be null");

		System.out.println("3 types of lazy init succeed.");
	}
}
