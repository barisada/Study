package books.effective_java.ch11.item75;

import java.io.Serializable;

/**
 * Created on 2018. 4. 29..
 */
public class DefaultSerializedExample implements Serializable{
	private static final long serialVersionUID = 813261672848778296L;

	private String firstName;
	private String LastName;
	private String middleName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Override public String toString() {
		return "DefaultSerializedExample{" +
				"firstName='" + firstName + '\'' +
				", LastName='" + LastName + '\'' +
				", middleName='" + middleName + '\'' +
				'}';
	}
}
