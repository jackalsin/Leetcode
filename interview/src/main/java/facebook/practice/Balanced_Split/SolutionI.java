package facebook.practice.Balanced_Split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
public final class SolutionI implements Solution {
  public boolean balancedSplitExists(int[] arr) {
    if (arr == null || arr.length == 0) return true;
    Arrays.sort(arr);
    long sum = 0;
    final Map<Long, List<Integer>> sums = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int a = arr[i];
      sum += a;
      sums.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
    }
    if (sum % 2 != 0) return false;
    if (!sums.containsKey(sum / 2)) return false;
    for (int leftEnd : sums.get(sum / 2)) {
      if (leftEnd < arr.length - 1 && arr[leftEnd] != arr[leftEnd + 1]) return true;
    }
    return false;
  }

}
