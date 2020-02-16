package _1301_1350._1354_Construct_Target_Array_With_Multiple_Sums;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean isPossible(int[] target) {
    int max = 0, maxIndex = 0;
    for (int i = 0; i < target.length; ++i) {
      if (max < target[i]) {
        max = target[i];
        maxIndex = i;
      }
    }

    if (max == 1) {
      return true;
    }
    for (int i = 0; i < target.length; ++i) {
      if (maxIndex == i) continue;
      max -= target[i];
      if (max < 1) {
        return false;
      }
    }
    target[maxIndex] = max;
    return isPossible(target);
  }

}
