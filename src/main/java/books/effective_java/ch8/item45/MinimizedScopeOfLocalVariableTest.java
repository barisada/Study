package books.effective_java.ch8.item45;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MinimizedScopeOfLocalVariableTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        System.out.println("idiom1 : ");
        MinimizedScopeOfLocalVariableEx.recommandIdiom1(list);

        Set<StopWatch> stopWatches = new LinkedHashSet<>();
        for(int i = 0; i < 10; i ++){
            StopWatch stopWatch = new StopWatch("T E S T " + (i+1));
            stopWatch.start("recommend");
            MinimizedScopeOfLocalVariableEx.recommandIdiom2(list);
            stopWatch.stop();

            stopWatch.start("notRecommend");
            MinimizedScopeOfLocalVariableEx.notRecommand(list);
            stopWatch.stop();
            stopWatches.add(stopWatch);
        }

        for(StopWatch sw : stopWatches){
            System.out.println(sw.prettyPrint());
        }


    }
}
