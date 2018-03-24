package books.effective_java.ch8.item46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class PreferForEachLoopExample {
    enum Suit{CLUB, DIAMOND, HEART, SPADE}
    enum Rank{ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
                NINE, TEN, JACK, QUEEN, KING}

    class Card{
        Rank rank;
        Suit suit;
        public Card(Rank rank, Suit suit){
            this.rank = rank;
            this.suit = suit;
        }
    }


    public List<Card> useForEachLoop(Collection<Rank> ranks, Collection<Suit> suits){
        List<Card> deck = new ArrayList<>();
        for(Suit suit : suits){
            for(Rank rank : ranks){
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }
}
