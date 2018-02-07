package books.effective_java.ch3.item11;

import java.util.Arrays;

public class CloneExample implements Cloneable {
    private int value;
    private Integer items[];
    private int itemSize;

    CloneExample(){
        value = 0;
        items = new Integer[16];
        itemSize = 0;
    }

    public void addItem(Integer item){
        checkArraySize();
        items[itemSize++] = item;
    }

    public void insert(int index, Integer value){
        items[index] = value;
    }

    public Integer get(int index){
        return items[index];
    }

    private void checkArraySize() {
        if(itemSize == items.length){
            items = Arrays.copyOf(items, itemSize * 2 + 1);
        }
    }

    @Override
    public CloneExample clone() throws CloneNotSupportedException {
        CloneExample result = (CloneExample) super.clone();
        result.value = this.value;
        result.items = new Integer[this.itemSize];
        result.items = Arrays.copyOf(this.items, this.itemSize);
        result.itemSize = this.itemSize;
        return result;
    }

    @Override
    public String toString() {
        return "CloneExample{" +
                "items=" + Arrays.toString(items) +
                '}';
    }
}
