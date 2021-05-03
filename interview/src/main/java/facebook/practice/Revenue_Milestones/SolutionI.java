package facebook.practice.Revenue_Milestones;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] getMilestoneDays(int[] revenues, int[] milestones) {
    final TreeMap<Integer, Integer> treeMap = new TreeMap<>();
    int sum = 0;
    treeMap.put(0, 0);
    for (int i = 0; i < revenues.length; i++) {
      final int r = revenues[i];
      sum += r;
      treeMap.put(sum, i + 1);
    }
    final int[] result = new int[milestones.length];
    for (int i = 0; i < milestones.length; ++i) {
      final Map.Entry<Integer, Integer> e = treeMap.ceilingEntry(milestones[i]);
      result[i] = e == null ? -1 : e.getValue();
    }
    return result;
  }
}
