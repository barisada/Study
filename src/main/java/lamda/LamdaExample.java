package lamda;

import java.util.ArrayList;
import java.util.List;

public class LamdaExample {
    private static String convert(Integer number, Conversion conversion){
        return conversion.convert(number);
    }

    private static <T> void initialize(List<T> list, Factory<T> factory){
        for(int i = 0; i < 10; i++){
            list.add(factory.create());
        }
    }

    public static void main(String[] args) {
        String converted = convert(100, String::valueOf);
        System.out.println(converted);

        Conversion conversion = String::valueOf;
        System.out.println(convert(200, conversion));

        List<String> list = new ArrayList<>();
        initialize(list, String::new);
        System.out.println(list);
    }

}

@FunctionalInterface
interface Conversion{
    String convert(Integer num);
}

@FunctionalInterface
interface Factory<T>{
    T create();
}

