package books.effective_java.ch8.item45;

import org.springframework.util.StopWatch;

import java.util.Iterator;
import java.util.List;

public class MinimizedScopeOfLocalVariableEx {
    public static void recommandIdiom1(List<? extends Object> list){
        for(Iterator<? extends Object> i = list.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
    }

    public static void recommandIdiom2(List<? extends Object> list){
        for(int i = 0, n = expensiveComputation(); i < n; i++){
            //System.out.println(list.get(i));
        }
    }

    public static void notRecommand(List<? extends Object> list){
        for(int i = 0; i < expensiveComputation(); i++){
            //System.out.println(list.get(i));
        }
    }

    private static int expensiveComputation() {
        String str = "";
        for(int i = 0; i < 5000; i++){
              str += String.valueOf(i);
        }
        return 5;
    }


}
