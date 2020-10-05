package _0551_0600._575_Distribute_Candies;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int distributeCandies(int[] candies) {
    final Set<Integer> visited = new HashSet<>();
    for (final int c : candies) {
      visited.add(c);
    }
    final int size = candies.length / 2;
    return Math.min(size, visited.size());
  }
}
