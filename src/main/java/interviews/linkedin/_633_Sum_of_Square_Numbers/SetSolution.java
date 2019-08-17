package interviews.linkedin._633_Sum_of_Square_Numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Time complexity: O(Sqrt(c))
 * Space complexity: O(Sqrt(c))
 *
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SetSolution implements Solution {
  public boolean judgeSquareSum(int c) {
    Set<Integer> validSquare = new HashSet<>();
    for (long i = 0; i * i <= c; i++) {
      int cur = (int) (i * i);
      validSquare.add(cur);
      int remain = c - cur;
      if (validSquare.contains(remain)) {
        return true;
      }
    }
    return false;
  }
}
