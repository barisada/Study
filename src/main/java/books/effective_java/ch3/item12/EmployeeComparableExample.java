package books.effective_java.ch3.item12;

public class EmployeeComparableExample implements Comparable<EmployeeComparableExample> {
    private String name;
    private int age;
    private String department;

    public EmployeeComparableExample(String name, int age, String department){
        this.name = name;
        this.age = age;
        this.department = department;
    }


    @Override
    public int compareTo(EmployeeComparableExample other) {
        if(this.name.compareTo(other.name) == 0){
            if(Integer.compare(this.age, other.age) == 0){
                return this.department.compareTo(other.department);
            } else {
                return Integer.compare(this.age, other.age);
            }

        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ']';
    }
}
