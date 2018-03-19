package books.effective_java.ch7.item41;

import java.util.*;

public class BadOverloadingExample {

    public static String classify(Set<?> s){
        return "Set";
    }

    public static String classify(List<?> list){
        return "list";
    }

    public static String classify(Collection<?> c){
        return "unknown";
    }

    public static String betterClassify(Collection<?> c){
        return c instanceof Set ? "set" :
                c instanceof List ? "list" : "unknown";

    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<>(), new ArrayList<>(), new HashMap<>().values()};


        //expect "set", "list", "unknown" respectively but not going to be work.
        //because overloading is static. but selection among overridden is dynamic.
        for(Collection<?> c : collections){
            System.out.println(classify(c));
        }

        System.out.println("========================");

        //use better and correct classify
        for(Collection<?> c : collections){
            System.out.println(betterClassify(c));
        }
    }
}


