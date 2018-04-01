package books.effective_java.ch8.item49;

/**
 * Created on 2018. 4. 1..
 */
public class BoxedPrimitiveExample {

	public int wrongCompare(Integer first, Integer second){
		return first < second ? -1 : (first == second ? 0 : 1);
	}

	public int rightCompare(Integer first, Integer second){
		int f = first;
		int s = second;
		return f < s ? -1 : (f == s ? 0 : 1);
	}

}
