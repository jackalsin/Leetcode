package _0601_0650._628_Maximum_Product_of_Three_Numbers;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhixi
 * @version 1.0 on 3/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maximumProduct(int[] nums) {
    if (nums == null || nums.length < 3) {
      return 0;
    }
    final Queue<Integer> positive = new PriorityQueue<>(), negative =
        new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    for (int num : nums) {
      positive.add(num);
      negative.add(num);
      if (positive.size() > 3) {
        positive.remove();
      }
      if (negative.size() > 2) {
        negative.remove();
      }
    }

    int pos = 1, neg = 0;
    while (!positive.isEmpty()) {
      neg = positive.remove(); // get the max positive number if it exist
      pos *= neg;
    }
    while (!negative.isEmpty()) {
      neg *= negative.remove();
    }
    return Math.max(pos, neg);
  }
}
