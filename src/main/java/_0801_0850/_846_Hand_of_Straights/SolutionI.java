package _0801_0850._846_Hand_of_Straights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/25/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isNStraightHand(int[] hand, int W) {
    Arrays.sort(hand);
//    System.out.println(Arrays.toString(hand));
    // last value -> count including it self, count
    final Map<Integer, Map<Integer, Integer>> unmatched = new HashMap<>();
    for (final int tail : hand) {
      if (unmatched.containsKey(tail - 1)) {
        final Map<Integer, Integer> continuousCountToCount = unmatched.get(tail - 1);
        final Map.Entry<Integer, Integer> e = continuousCountToCount.entrySet().iterator().next();
        final int continuousCount = e.getKey(), count = e.getValue();

        // clean up the old
        if (count == 1) {
          continuousCountToCount.remove(continuousCount);
          if (continuousCountToCount.isEmpty()) {
            unmatched.remove(tail - 1);
          }
        } else {
          continuousCountToCount.put(continuousCount, count - 1);
        }
        // add to unmatched group iff it's still not reaching the
        if (continuousCount != W - 1) {
          unmatched.putIfAbsent(tail, new HashMap<>());
          final Map<Integer, Integer> tailMap = unmatched.get(tail);
          tailMap.put(continuousCount + 1, tailMap.getOrDefault(continuousCount + 1, 0) + 1);
        }
      } else if (W != 1) {
        unmatched.putIfAbsent(tail, new HashMap<>());
        final Map<Integer, Integer> tailMap = unmatched.get(tail);
        tailMap.put(1, tailMap.getOrDefault(1, 0) + 1);
      }
//      System.out.printf("tail = %d, unmatched = %s\n", tail, unmatched);
    }
    return unmatched.isEmpty();
  }
}
