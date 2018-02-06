package books.effective_java.ch3.item8_9_10;

public class OverridingChild extends OverridingEqualHashCodeToString {

    public OverridingChild(String name, int value){
        super(name, value);
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
