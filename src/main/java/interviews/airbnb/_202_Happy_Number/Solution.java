package interviews.airbnb._202_Happy_Number;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public class Solution {
  public boolean isHappy(int n) {
    if (n <= 0) return false;
    final Set<Integer> visited = new HashSet<>();
    while (n != 1) {
      if (visited.contains(n)) {
        return false;
      }
      visited.add(n);
      int nextN = 0;
      while (n != 0) {
        final int digit = n % 10;
        n /= 10;
        nextN += +digit * digit;
      }
      n = nextN;
    }
    return true;
  }
}
