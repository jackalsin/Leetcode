package _0501_0550._517_Super_Washing_Machines;

import java.util.Arrays;

public class Solution {
  /**
   * @param machines
   * @return
   */
  public int findMinMoves(int[] machines) {
    final int sum = Arrays.stream(machines).sum();

    if (sum % machines.length != 0) {
      return -1;
    }

    final int target = sum / machines.length;

    return move(machines, target);
  }

  private int move(final int[] machines, final int target) {
    assert machines.length != 0;
    int count = 0, max = 0;
    for (int machine : machines) {
      int cur = machine - target;
      count += cur;
      max = Math.max(Math.max(max, Math.abs(count)), cur);
      // Notice: if use Math.abs(cur): 其实题目只说了只能一件件给，没说不能一起一起收
//      max = Math.max(Math.max(max, Math.abs(count)), Math.abs(cur));
    }
    return max;
  }
}
