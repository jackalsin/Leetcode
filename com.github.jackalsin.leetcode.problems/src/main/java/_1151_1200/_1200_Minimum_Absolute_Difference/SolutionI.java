package _1151_1200._1200_Minimum_Absolute_Difference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/21/2019
 */
public class SolutionI implements Solution {
  @Override
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    final List<List<Integer>> result = new ArrayList<>();
    if (arr == null || arr.length == 0) {
      return result;
    }
    Arrays.sort(arr);
//    final Set<Integer> values = new HashSet<>();
    long minDiff = Long.MAX_VALUE;
    for (int i = 1; i < arr.length; ++i) {
      final long curDiff = Math.abs((long) arr[i] - arr[i - 1]);
      if (curDiff <= minDiff) {
        if (curDiff < minDiff) {
          minDiff = curDiff;
          result.clear();
        }
        result.add(Arrays.asList(arr[i - 1], arr[i]));
      }
    }
    return result;
  }
}
