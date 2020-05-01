package _1251_1300._1262_Greatest_Sum_Divisible_by_Three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/1/2020
 */
public final class ReverseDeductionSolution implements Solution {
  @Override
  public int maxSumDivThree(int[] nums) {
    int sum = 0;
    final List<Integer> ones = new ArrayList<>(), twos = new ArrayList<>();
    for (int n : nums) {
      final int r = n % 3;
      if (r == 1) {
        ones.add(n);
        if (ones.size() > 2) {
          Collections.sort(ones);
          ones.remove(ones.size() - 1);
        }
      } else if (r == 2) {
        twos.add(n);
        if (twos.size() > 2) {
          Collections.sort(twos);
          twos.remove(twos.size() - 1);
        }
      }
      sum += n;
    }
    Collections.sort(ones);
    Collections.sort(twos);
//    System.out.println(sum + ", ones = " + ones + ", twos = " + twos);

    if (sum % 3 == 1) {
      int toRemove = Integer.MAX_VALUE;
      if (!ones.isEmpty()) {
        toRemove = Math.min(toRemove, ones.get(0));
      }
      if (twos.size() >= 2) {
        toRemove = Math.min(toRemove, twos.get(0) + twos.get(1));
      }
      if (toRemove == Integer.MAX_VALUE) {
        return 0;
      } else {
        return sum - toRemove;
      }
    } else if (sum % 3 == 2) {
      int toRemove = Integer.MAX_VALUE;
      if (!twos.isEmpty()) {
        toRemove = Math.min(toRemove, twos.get(0));
      }
      if (ones.size() >= 2) {
        toRemove = Math.min(toRemove, ones.get(0) + ones.get(1));
      }
      if (toRemove == Integer.MAX_VALUE) {
        return 0;
      } else {
        return sum - toRemove;
      }
    }
    return sum;
  }
}
