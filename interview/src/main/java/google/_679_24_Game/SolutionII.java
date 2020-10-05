package google._679_24_Game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jacka
 * @version 1.0 on 1/10/2018.
 */
public final class SolutionII implements Solution {
  private static final double BIAS = 1E-7;

  public boolean judgePoint24(int[] nums) {
    List<Double> doubles = Arrays.stream(nums).mapToDouble(value -> (double) value).boxed().collect
        (Collectors.toList());
    return helper(doubles);
  }

  private boolean helper(final List<Double> nums) {
    if (nums.size() == 1) {
      return Math.abs(nums.get(0) - 24) < BIAS;
    }

    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.size(); j++) {
        if (i == j) {
          continue;
        }
        final List<Double> newNums = new ArrayList<>();
        for (int k = 0, l = 0; k < nums.size(); k++) {
          if (k != i && k != j) {
            newNums.add(nums.get(k));
          }
        }
        for (int op = 0; op < 4; op++) {
          if (op < 2 && i < j) {
            continue;
          }
          if (op == 0) {
            newNums.add(nums.get(i) + nums.get(j));
          } else if (op == 1) {
            newNums.add(nums.get(i) * nums.get(j));
          } else if (op == 2) {
            newNums.add(nums.get(i) - nums.get(j));
          } else {
            if (nums.get(j) == 0) {
              continue;
            }
            newNums.add(nums.get(i) / nums.get(j));
          }
          if (helper(newNums)) {
            return true;
          }
          newNums.remove(newNums.size() - 1);
        }

      }
    }
    return false;
  }
}
