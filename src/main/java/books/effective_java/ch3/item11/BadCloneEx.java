package books.effective_java.ch3.item11;

public class BadCloneEx implements Cloneable {
    Integer[] array = new Integer[16];

    public void add(int index){
        array[index] = index;
    }

    public void insert(int index, int value){
        array[index] = value;
    }

    public Integer get(int index){
        return array[index];
    }

    @Override
    public BadCloneEx clone() throws CloneNotSupportedException {
        BadCloneEx result = (BadCloneEx) super.clone();
        result.array = array;
        return result;

    }
}
