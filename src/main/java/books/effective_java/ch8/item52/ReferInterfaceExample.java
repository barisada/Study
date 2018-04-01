package books.effective_java.ch8.item52;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/**
 * Created on 2018. 4. 1..
 */
public class ReferInterfaceExample {
	public static void referInterface(List<?> list){
		System.out.println(list);
	}

	public static void main(String[] args) {
		ArrayList<Void> arrayList = new ArrayList<>();
		Vector<Integer> vector = new Vector<>();
		LinkedList<String> linkedList = new LinkedList<>();
		arrayList.add(null);
		vector.add(1);vector.add(2);
		linkedList.add("a");linkedList.add("b");linkedList.add("C");

		//can use any of them.
		referInterface(arrayList);
		referInterface(vector);
		referInterface(linkedList);
	}
}
