package byteDance._1262_Greatest_Sum_Divisible_by_Three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxSumDivThree(int[] nums) {
    int sum = 0;
    final List<Integer> ones = new ArrayList<>(),
        twos = new ArrayList<>();
    for (final int n : nums) {
      final int r = n % 3;
      sum += n;
      if (r == 1) {
        ones.add(n);
      } else if (r == 2) {
        twos.add(n);
      }
    }
    Collections.sort(ones);
    Collections.sort(twos);
    if (sum % 3 == 0) {
      return sum;
    } else if (sum % 3 == 1) {
      int res = 0;
      if (!ones.isEmpty()) {
        res = Math.max(res, sum - ones.get(0));
      }
      if (twos.size() >= 2) {
        res = Math.max(res, sum - twos.get(0) - twos.get(1));
      }
      return res;
    } else {
      int res = 0;
      if (!twos.isEmpty()) {
        res = Math.max(res, sum - twos.get(0));
      }
      if (ones.size() >= 2) {
        res = Math.max(res, sum - ones.get(0) - ones.get(1));
      }
      return res;
    }
  }
}
