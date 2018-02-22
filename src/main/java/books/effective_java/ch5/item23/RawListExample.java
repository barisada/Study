package books.effective_java.ch5.item23;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class RawListExample {
    public void rawTypeAdd(List list, Object o){
        list.add(o);
    }

    public static void main(String[] args) {
        RawListExample ex = new RawListExample();
        List<String> list = new ArrayList<>();
        ex.rawTypeAdd(list, BigInteger.ONE);
        try{

            String str = list.get(0);
        } catch (ClassCastException e){
            e.printStackTrace();
            System.out.println("error occur as expected");
        }
    }

}
