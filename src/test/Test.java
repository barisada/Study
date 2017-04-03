import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by jwlee1 on 2017. 4. 2..
 */
public class Test {
	public static void main(String...args){
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);list.add(1);
		list.set(0, 3);
		Collections.sort(list);

		System.out.println(list);
	}
}
