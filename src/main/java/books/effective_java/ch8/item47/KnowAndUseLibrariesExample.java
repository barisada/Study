package books.effective_java.ch8.item47;


import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * Created by jw on 2018-03-29.
 */
public final class KnowAndUseLibrariesExample {

    //use Random.nextInt() for generating random number
    public static int randomNumberGenerator(int bound){
        return new Random().nextInt(bound);
    }

    //know Collection package
    public static void binarySearch(){
        Set<Integer> list  = IntStream.range(1, Math.max(10, randomNumberGenerator(20)))
                .map(KnowAndUseLibrariesExample::randomNumberGenerator).sorted()
                .boxed().collect(Collectors.toSet());

        int target = randomNumberGenerator(20);
        System.out.println("binary search list : " + list + " , try to find " + target);
        int result = Collections.binarySearch(new ArrayList<>(list), target);
        System.out.println(result >= 0 ? "found at index " + result : target + " not exist in this list");
    }

    public static void main(String[] args) {
        int ran1 = randomNumberGenerator(Integer.MAX_VALUE);
        int ran2 = randomNumberGenerator(Integer.MAX_VALUE);
        System.out.println(ran1 + " vs " + ran2);
        Assert.isTrue(ran1 != ran2, "hopefully not same");

        binarySearch();
    }
}
