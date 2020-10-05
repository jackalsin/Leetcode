package _0551_0600._599_Minimum_Index_Sum_of_Two_Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/13/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String[] findRestaurant(String[] list1, String[] list2) {
    final Map<String, Integer> indexes = new HashMap<>();
    for (int i = 0; i < list1.length; ++i) {
      indexes.putIfAbsent(list1[i], i);
    }
    long min = Long.MAX_VALUE;
    final List<String> result = new ArrayList<>();
    for (int i = 0; i < list2.length; ++i) {
      final String word = list2[i];
      if (!indexes.containsKey(word)) {
        continue;
      }
      final long cur = (long) indexes.get(word) + i;
      if (cur <= min) {
        if (cur == min) {
          result.add(word);
        } else {
          min = cur;
          result.clear();
          result.add(word);
        }
      }
    }
    return result.toArray(new String[]{});
  }
}
