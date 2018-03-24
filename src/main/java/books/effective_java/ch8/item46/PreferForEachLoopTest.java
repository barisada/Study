package books.effective_java.ch8.item46;

import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PreferForEachLoopTest {

    public static void main(String[] args) {
        PreferForEachLoopExample ex = new PreferForEachLoopExample();
        Collection<PreferForEachLoopExample.Suit> suits =
                Arrays.asList(PreferForEachLoopExample.Suit.values());
        Collection<PreferForEachLoopExample.Rank> ranks =
                Arrays.asList(PreferForEachLoopExample.Rank.values());

        List<PreferForEachLoopExample.Card> deck = ex.useForEachLoop(ranks, suits);

        System.out.println("Deck size : " + deck.size());
        Assert.isTrue(deck.size() == 52, "card size must 52");
    }
}
