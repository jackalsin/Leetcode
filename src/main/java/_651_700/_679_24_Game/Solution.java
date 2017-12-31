package _651_700._679_24_Game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 12/30/2017.
 */
public class Solution {
  private static final double BIAS = 1e-7;

  public boolean judgePoint24(int[] nums) {
    List<Double> numsCopy = new ArrayList<>();
    for (int num : nums) {
      numsCopy.add((double) num);
    }
    return solve(numsCopy);

  }

  private boolean solve(List<Double> nums) {
    if (nums.size() == 1) {
      return Math.abs(nums.get(0) - 24) < BIAS;
    }
    for (int i = 0; i < nums.size(); i++) {
      for (int j = 0; j < nums.size(); j++) {
        if (i == j) {
          continue;
        }
        List<Double> newNums = new ArrayList<>();
        for (int k = 0; k < nums.size(); k++) {
          if (k != j && k != i) {
            newNums.add(nums.get(k));
          }
        }
        for (int k = 0; k < 4; k++) {
          if (k < 2 && j < i) {
            continue;
          }
          switch (k) {
            case 0:
              newNums.add(nums.get(i) + nums.get(j));
              break;
            case 1:
              newNums.add(nums.get(i) * nums.get(j));
              break;
            case 2:
              newNums.add(nums.get(i) - nums.get(j));
              break;
            case 3:
              if (nums.get(j) != 0) {
                newNums.add(nums.get(i) / nums.get(j));
              } else {
                continue;
              }
          } // end of switch
          if (solve(newNums)) {
            return true;
          }
          newNums.remove(newNums.size() - 1);
        }
      }
    }
    return false;
  }
}
