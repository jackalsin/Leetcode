package _0751_0800._781_Rabbits_in_Forest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/30/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numRabbits(int[] answers) {
    /*
    How many unmatch for this color
    */
    final Map<Integer, Integer> remainUnmatch = new HashMap<>();
    int count = 0;
    for (final int a : answers) {
      if (remainUnmatch.containsKey(a)) {
        final int cur = remainUnmatch.get(a);
        if (cur == 1) {
          remainUnmatch.remove(a);
        } else {
          remainUnmatch.put(a, cur - 1);
        }
      } else {
        if (a != 0) {
          remainUnmatch.put(a, a);
        }
        count += a + 1;
      }
    }
    return count;
  }
}
