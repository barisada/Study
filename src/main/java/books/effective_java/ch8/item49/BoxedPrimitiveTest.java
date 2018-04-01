package books.effective_java.ch8.item49;

/**
 * Created on 2018. 4. 1..
 */
public class BoxedPrimitiveTest {

	public static void main(String[] args) {
		BoxedPrimitiveExample ex = new BoxedPrimitiveExample();
		System.out.println("unbelievably not same : " + ex.wrongCompare(new Integer(42),new Integer(42)));

		System.out.println("same : " + ex.rightCompare(new Integer(42), new Integer(42)));
	}
}
