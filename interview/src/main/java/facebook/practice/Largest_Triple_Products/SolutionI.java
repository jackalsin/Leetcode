package facebook.practice.Largest_Triple_Products;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 5/1/2021
 */
public final class SolutionI implements Solution {
  public int[] findMaxProduct(int[] arr) {
    if (arr == null || arr.length == 0) return arr;
    final Queue<Integer> pq = new PriorityQueue<>(Integer::compare);
    final int n = arr.length;
    final int[] result = new int[n];
    if (n <= 2) {
      Arrays.fill(result, -1);
      return result;
    }
    long mul = 1;
    for (int i = 0; i < n; ++i) {
      mul *= arr[i];
      pq.add(arr[i]);
      if (pq.size() > 3) {
        mul /= pq.remove();
      }
      result[i] = i < 2 ? -1 : (int) mul;
    }
    return result;
  }
}
