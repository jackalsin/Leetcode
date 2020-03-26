package _0801_0850._846_Hand_of_Straights;

import java.util.ArrayDeque;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/25/2020
 */
public final class Lee215Solution implements Solution {
  @Override
  public boolean isNStraightHand(int[] hand, int W) {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    for (final int h : hand) {
      treeMap.put(h, treeMap.getOrDefault(h, 0) + 1);
    }
    int lastElement = -1, open = 0;
    final Queue<Integer> q = new ArrayDeque<>();
    for (final Map.Entry<Integer, Integer> e : treeMap.entrySet()) {
      final int key = e.getKey(), val = e.getValue();
      if (open > 0 && key != lastElement + 1 || val < open) return false;
      q.add(val - open); // new added
      open = val;
      lastElement = key;
      if (q.size() == W) {
        open -= q.remove();
      }
    }
    return open == 0;
  }
}
