package _0901_0950._950_Reveal_Cards_In_Increasing_Order;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 9/27/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] deckRevealedIncreasing(int[] deck) {
    final int n = deck.length;
    if (n == 0) {
      return deck;
    }
    Arrays.sort(deck);
    final Deque<Integer> result = new ArrayDeque<>();
    result.add(deck[n - 1]);
    for (int i = n - 2; i >= 0; --i) {
      final int tail = result.removeLast();
      result.addFirst(tail);
      result.addFirst(deck[i]);
    }
    return result.stream().mapToInt(x -> x).toArray();
  }

}
