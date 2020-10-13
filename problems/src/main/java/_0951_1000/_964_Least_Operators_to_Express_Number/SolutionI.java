package _0951_1000._964_Least_Operators_to_Express_Number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/12/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Integer> cache = new HashMap<>();
  private long[] powers;

  public int leastOpsExpressTarget(int x, int target) {
    initPower(x, target);
//    System.out.println("x = " + x + ", target = " + target);
    if (x == target) {
      return 0;
    }
    if (target < x) {
      // x / x + x/ x + ... + x/x or target - x/x - x/x - ... - x/x
      return Math.min(target * 2 - 1, (x - target) * 2);
    }
    if (cache.containsKey(target)) {
      return cache.get(target);
    }
    final int times = getLowerBoundTimes(target);
    long base = powers[times];
//    System.out.println("times = " + times + ", base = " + base);
    int res = Integer.MAX_VALUE;
    if (target >= base) {
      res = Math.min(res, times + leastOpsExpressTarget(x, (int) (target - base)));
    }
    if (target * 2L > base * x) {
      res = Math.min(res, times + 1 + leastOpsExpressTarget(x, (int) (base * x - target)));
    }
    cache.put(target, res);
//    System.out.println("return target = " + target);
    return res;
  }

  private void initPower(long x, int target) {
    if (powers != null) return;
    final int times = (int) Math.ceil((Math.log(target) / Math.log(x)));
    powers = new long[times + 2];
    for (int i = 0, cur = 1; i < powers.length; i++, cur *= x) {
      powers[i] = cur;
    }
//    System.out.println(Arrays.toString(powers));
  }

  /**
   * 要找最后一个小于等于
   */
  private int getLowerBoundTimes(int target) {
//    System.out.println("target = " + target);
    int left = 0, right = powers.length - 1;
    while (left < right) {
      final int mid = left + (right - left + 1) / 2;
      if (powers[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    assert powers[left] <= target;
    return left;
  }

}
