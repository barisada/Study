package books.effective_java.ch11.item74;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created on 2018. 4. 29..
 */
public class Foo extends AbstractFoo implements Serializable {
	private static final long serialVersionUID = 5155256336703221977L;

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();

		int x = s.readInt();
		int y = s.readInt();
		initialize(x, y);
	}

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();

		s.writeInt(getX());
		s.writeInt(getY());
	}

	public Foo(int x, int y){
		super(x, y);
	}

	@Override
	public String toString(){
		return "x : " + getX() + "\r\n"
				+ "y : " + getY() + "\r\n"
				+ "state : " + getState();

	}

}
