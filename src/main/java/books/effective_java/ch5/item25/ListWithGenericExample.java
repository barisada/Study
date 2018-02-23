package books.effective_java.ch5.item25;

import java.util.ArrayList;
import java.util.List;

public class ListWithGenericExample {

    static Object reduceWithoutGenericAndConcurrencySupport(List list, Function f, Object initVal){
        synchronized (list){
            Object result = initVal;
            for(Object o : list){
                result = f.apply(result, o);
                if(Integer.valueOf(o.toString()) == 6) list.remove(5);
            }

            System.out.println(list);
            return result;
        }
    }

    static Object reduceWithoutGeneric(List list, Function f, Object initVal){
        Object[] snapshot = list.toArray(); //Locks List internally
        Object result = initVal;
        int i = 0;
        for(Object o : snapshot){
            result = f.apply(result, o);
            Object temp = snapshot[i];
            snapshot[i++] = null;
            System.out.println("removed item : " + temp);
        }
        return result;
    }

    static <E> E reduce(List<E> list, Function2<E> f, E initVal){
        List<E> snapshot;
        synchronized (list){
            snapshot = new ArrayList<>(list);
        }
        E result = initVal;
        int i = 0;
        for(E e : snapshot){
            result = f.apply(result, e);
            int temp = Integer.valueOf(e.toString());
            if(temp == 6) list.remove(5);
        }
        return result;
    }

    interface Function{
        Object apply(Object obj1, Object obj2);
    }

    interface Function2<E>{
        E apply(E e1, E e2);
    }
}
