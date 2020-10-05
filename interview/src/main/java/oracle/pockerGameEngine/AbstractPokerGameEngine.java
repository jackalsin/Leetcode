package oracle.pockerGameEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/26/2019
 */
public abstract class AbstractPokerGameEngine {

  private final List<Card> deck = new ArrayList<>();
  private Iterator<Card> curCard;

  protected AbstractPokerGameEngine() {
    for (int i = 1; i <= 13; ++i) {
      deck.add(new Card(Suit.SPADE, i));
      deck.add(new Card(Suit.HEART, i));
      deck.add(new Card(Suit.CLUB, i));
      deck.add(new Card(Suit.DIAMOND, i));
    }
    curCard = deck.iterator();
  }

  protected void shuffle() {
    Collections.shuffle(deck);
  }

  protected void reset() {
    shuffle();
    curCard = deck.iterator();
  }

  protected Card draw() {
    assert curCard.hasNext();
    return curCard.next();
  }

  private static final class Card {
    private final Suit suit;
    private final int num;

    private Card(Suit suit, int num) {
      this.suit = suit;
      this.num = num;
    }
  }

  private enum Suit {
    //    黑桃（Spade）、红桃（Heart）、方块（Diamond）、梅花（Club
    SPADE, HEART, DIAMOND, CLUB
  }
}
