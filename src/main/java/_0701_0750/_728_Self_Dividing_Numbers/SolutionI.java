package _0701_0750._728_Self_Dividing_Numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> selfDividingNumbers(int left, int right) {
    final List<Integer> result = new ArrayList<>();
    for (int num = left; num <= right; ++num) {
      if (isSelfDividing(num)) {
        result.add(num);
      }
    }
    return result;
  }

  private static boolean isSelfDividing(final int num) {
    int remain = num;
    while (remain != 0) {
      final int digit = remain % 10;
      if (digit == 0 || num % digit != 0) return false;
      remain /= 10;
    }
    return true;
  }
}
