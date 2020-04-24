package _1351_1400._1388_Pizza_With_3n_Slices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
public final class SolutionI implements Solution {
  private Map<List<Integer>, Integer> cache = new HashMap<>();

  public int maxSizeSlices(int[] slices) {
    final List<Integer> sliceList = new ArrayList<>();
    for (int s : slices) {
      sliceList.add(s);
    }
    return maxSizeSlices(sliceList);
  }

  private int maxSizeSlices(final List<Integer> slices) {
    if (slices.isEmpty()) {
      return 0;
    }
    if (cache.containsKey(slices)) {
      return cache.get(slices);
    }
    int max = 0;
    for (int i = 0; i < slices.size(); ++i) {
      final List<Integer> next = new ArrayList<>();
      if (i == 0) {
        next.addAll(slices.subList(2, slices.size() - 1));
      } else if (i == slices.size() - 1) {
        next.addAll(slices.subList(1, slices.size() - 2));
      } else {
        next.addAll(slices.subList(0, i - 1));
        next.addAll(slices.subList(i + 2, slices.size()));
      }
//      System.out.println("i = " + i + ", src = " + slices + ", next = " + next);
      final int cur = maxSizeSlices(next);
      max = Math.max(max, cur + slices.get(i));
    }
    cache.put(slices, max);
    return max;
  }
}
