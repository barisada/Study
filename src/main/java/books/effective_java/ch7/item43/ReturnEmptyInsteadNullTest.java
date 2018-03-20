package books.effective_java.ch7.item43;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class ReturnEmptyInsteadNullTest {
    public static void main(String[] args) {
        ReturnEmptyInsteadNullExample ex = new ReturnEmptyInsteadNullExample();

        ReturnEmptyInsteadNullExample.Cheese[] arr = ex.getChesses();
        Assert.notNull(arr, "cheese[] cannot be null");
        System.out.println(Arrays.toString(arr));

        List<ReturnEmptyInsteadNullExample.Cheese> list = ex.getCheeseList();
        List<ReturnEmptyInsteadNullExample.Cheese> list2 = ex.getCheeseList();
        System.out.println(list + " " + list2);
        Assert.isTrue(list.hashCode() == list2.hashCode(),
                "Empty Cheese lists must be same since it return same immutable object");

        ex.addCheese();

        List<ReturnEmptyInsteadNullExample.Cheese> list3 = ex.getCheeseList();
        List<ReturnEmptyInsteadNullExample.Cheese> list4 = ex.getCheeseList();
        System.out.println(list3 + " " + list4);
        Assert.isTrue(list3.equals(list4),
                "Cheese lists must be same if contents are same " +
                        "since it return same defencive copy list");

    }
}
