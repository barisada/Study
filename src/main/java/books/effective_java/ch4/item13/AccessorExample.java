package books.effective_java.ch4.item13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AccessorExample {

    private Object privateAccessor;
    Object defaultAccessor;
    protected Object protectedAccessor;
    public Object publicAccessor;

    public static final Object[] BAD_VALUES = {1,2,3};

    private static final Object[] GOOD_VALUES = {1,2,3};
    public static final List<Object> GOOD_VALUES_FOR_CLIENT =
            Collections.unmodifiableList(Arrays.asList(GOOD_VALUES));

    //OR
    public static final Object[] getGoodValues(){
        return GOOD_VALUES.clone();
    }

    public static void main(String[] args) {

        try{
            GOOD_VALUES_FOR_CLIENT.add("new");
        } catch(Exception e){
            e.printStackTrace();
        }

        Object[] cloneObj = AccessorExample.getGoodValues();
        cloneObj[0] = "new";
        System.out.println(Arrays.asList(cloneObj));

    }

}
