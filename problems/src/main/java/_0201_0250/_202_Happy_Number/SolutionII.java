package _0201_0250._202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
public final class SolutionII implements Solution {
  @Override
  public boolean isHappy(int n) {
    final Set<Integer> visited = new HashSet<>();
    while (!visited.contains(n)) {
      visited.add(n);
      final int next = getNext(n);
      if (next == 1) {
        return true;
      }
      n = next;
    }
    return false;
  }

  private static int getNext(int n) {
    int res = 0;
    while (n != 0) {
      final int d = n % 10;
      res += d * d;
      n /= 10;
    }
    return res;
  }
}
