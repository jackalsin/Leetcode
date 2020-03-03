package _0551_0600._600_Non_negative_Integers_without_Consecutive_Ones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/2/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String[] findRestaurant(String[] list1, String[] list2) {
    if (list1 == null || list2 == null) {
      return new String[0];
    }
    final Map<String, Integer> reverseIndex = new HashMap<>();
    for (int i = 0; i < list1.length; ++i) {
      reverseIndex.put(list1[i], i);
    }
    final List<String> result = new ArrayList<>();
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list2.length; ++i) {
      if (reverseIndex.containsKey(list2[i])) {
        final int cur = reverseIndex.get(list2[i]) + i;
        if (cur <= min) {
          if (cur < min) {
            min = cur;
            result.clear();
          }
          result.add(list2[i]);
        }
      }
    }
    return result.toArray(new String[0]);
  }
}
