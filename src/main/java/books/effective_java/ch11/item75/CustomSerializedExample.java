package books.effective_java.ch11.item75;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2018. 4. 29..
 */
public class CustomSerializedExample implements Serializable{
	private String name;
	private List<String> friends;
	private int numOfFriends;

	private void writeObject(ObjectOutputStream s) throws IOException {
		s.defaultWriteObject();
		s.writeObject(name);
		s.writeInt(numOfFriends);

		for(String friend : friends){
			s.writeObject(friend);
		}
	}

	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();
		setName(String.valueOf(s.readObject()));
		setNumOfFriends(s.readInt());

		List<String> friends = new ArrayList<>(getNumOfFriends());
		for(int i = 0; i < friends.size(); i++){
			friends.add(String.valueOf(s.readObject()));
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getFriends() {
		return friends;
	}

	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public int getNumOfFriends() {
		return numOfFriends;
	}

	public void setNumOfFriends(int numOfFriends) {
		this.numOfFriends = numOfFriends;
	}

	@Override public String toString() {
		return "CustomSerializedExample{" +
				"name='" + name + '\'' +
				", friends=" + friends +
				", numOfFriends=" + numOfFriends +
				'}';
	}
}
