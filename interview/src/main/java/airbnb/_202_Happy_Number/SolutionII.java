package airbnb._202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class SolutionII implements Solution {
  @Override
  public boolean isHappy(int n) {
    final Set<Integer> visited = new HashSet<>();
    while (n != 1) {
      int next = 0;
      while (n != 0) {
        final int d = n % 10;
        next += d * d;
        n /= 10;

      }
      if (visited.contains(next)) return false;
      visited.add(next);
      n = next;
    }
    return true;
  }
}
