package linkedin._350_Intersection_of_Two_Arrays_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/11/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int[] intersect(int[] nums1, int[] nums2) {
    final Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums1) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    final List<Integer> result = new ArrayList<>();
    for (int i : nums2) {
      if (map.containsKey(i)) {
        final int count = map.get(i);
        if (count == 1) {
          map.remove(i);
        } else {
          map.put(i, count - 1);
        }
        result.add(i);
      }
    }
    final int[] resultArray = new int[result.size()];
    for (int i = 0; i < result.size(); i++) {
      resultArray[i] = result.get(i);
    }
    return resultArray;
  }
}
