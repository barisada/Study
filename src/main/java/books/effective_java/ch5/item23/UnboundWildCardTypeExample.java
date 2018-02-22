package books.effective_java.ch5.item23;

import java.util.HashSet;
import java.util.Set;

public class UnboundWildCardTypeExample {

    static int numElementInCommon(Set<?> s1, Set<?> s2){
        int result = 0;
        for(Object obj : s1){
            if(s2.contains(obj)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int result = numElementInCommon(
                new HashSet<>(){
                    {
                        this.add(1);
                        this.add(2);
                        this.add(3);
                    }
                },
                new HashSet<>() {
                    {
                        this.add(1);
                        this.add("2");
                        this.add(3.0);
                    }
                }
        );

        System.out.println(result);
    }
}
