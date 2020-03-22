package _1351_1400._1389_Create_Target_Array_in_the_Given_Order;

import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] createTargetArray(int[] nums, int[] index) {
    final LinkedList<Integer> result = new LinkedList<>();
    for (int i = 0; i < nums.length; i++) {
      result.add(index[i], nums[i]);
    }
    final int[] res = new int[nums.length];
    int i = 0;
    for (int e : result) {
      res[i++] = e;
    }
    return res;
  }
}
