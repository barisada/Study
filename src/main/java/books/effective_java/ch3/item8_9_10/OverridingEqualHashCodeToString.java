package books.effective_java.ch3.item8_9_10;

import java.util.HashSet;
import java.util.Set;

public class OverridingEqualHashCodeToString {
    private static final Set<OverridingEqualHashCodeToString> goals;
    static{
        goals = new HashSet<>();
        goals.add(new OverridingEqualHashCodeToString("first", 1));
        goals.add(new OverridingEqualHashCodeToString("second" ,2));

    }
    private String name;
    private int value;

    public OverridingEqualHashCodeToString(String name, int value){
        this.name = name;
        this.value = value;
    }

    public static boolean isGoal(OverridingEqualHashCodeToString obj){
        return goals.contains(obj);
    }

    public static OverridingEqualHashCodeToString getFirstGoal(){
        return goals.iterator().next();
    }

    public int getValue(){
        return this.value;
    }

    public String getName(){
        return this.name;
    }


    /* auto generated equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OverridingEqualHashCodeToString)) return false;
        OverridingEqualHashCodeToString that = (OverridingEqualHashCodeToString) o;
        return getValue() == that.getValue() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getValue());
    }*/

    @Override
    public boolean equals(Object o){
        //must check instance
        if(!(o instanceof OverridingEqualHashCodeToString)) return false;
        OverridingEqualHashCodeToString temp = (OverridingEqualHashCodeToString) o;
        return temp.getValue() == this.value && this.name.equals(temp.getName());

    }

    @Override
    public int hashCode(){
        int result = this.name.hashCode();
        result = 31 * result + this.value;
        return result;
    }

    @Override
    public String toString() {
        return "OverridingEqualHashCodeToString{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
