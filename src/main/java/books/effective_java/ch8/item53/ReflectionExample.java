package books.effective_java.ch8.item53;

import java.util.Arrays;
import java.util.Random;
import java.util.Set;

/**
 * Created on 2018. 4. 1..
 */
public class ReflectionExample {

	//not very recommended way to instantiate Set
	public static void main(String[] args) {
		args = new String[30];
		args[0] = "java.util.HashSet";
		for(int i  = 1; i < 30; i++){
			args[i] = String.valueOf((char) (i + new Random().nextInt(20) + 60));
		}
		//HashSet
		reflectSet(args);

		//TreeSet
		args[0] = "java.util.TreeSet";
		reflectSet(args);

	}

	private static void reflectSet(String[] args) {
		// Translate the class name into a Class object
		Class<?> cl = null;
		try {
			cl = Class.forName(args[0]);
		} catch(ClassNotFoundException e) {
			System.err.println("Class not found.");
			System.exit(1);
		}
		// Instantiate the class
		Set<String> s = null;
		try {
			s = (Set<String>) cl.newInstance();
		} catch(IllegalAccessException e) {
			System.err.println("Class not accessible.");
			System.exit(1);
		} catch(InstantiationException e) {
			System.err.println("Class not instantiable.");
			System.exit(1);
		}
		// Exercise the set
		s.addAll(Arrays.asList(args).subList(1, args.length));
		System.out.println(args[0] + ": " + s);
	}
}
