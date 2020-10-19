package _1001_1050._1018_Binary_Prefix_Divisible_By_5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Boolean> prefixesDivBy5(int[] A) {
    int remain = 0;
    final List<Boolean> result = new ArrayList<>();
    for (int a : A) {
      remain = (remain * 2 + a) % 5;
      result.add(remain == 0);
    }
    return result;
  }
}
