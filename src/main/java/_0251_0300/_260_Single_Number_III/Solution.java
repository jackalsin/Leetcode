package _0251_0300._260_Single_Number_III;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/5/2017.
 */
public class Solution {
  public int[] singleNumber(int[] nums) {
//    return oNSolution(nums);
    return o1Solution(nums);
  }

  /**
   * https://discuss.leetcode.com/topic/21883/my-java-solution-adapted-from-the-commonest-solution-here
   * Xor all numbers and get a <code>diff</code>, then find a bit in diff, which can distinguish
   * the 2 single numbers.
   *
   * @param nums
   * @return
   */
  private int[] o1Solution(int[] nums) {
    int diff = 0;
    for (int i : nums) {
      diff ^= i;
    }
    diff = Integer.highestOneBit(diff);
    diff &= -diff;
    int[] result = new int[2];
    for (int i : nums) {
      if ((i & diff) == 0) {
        result[0] ^= i;
      } else {
        result[1] ^= i;
      }
    }
    return result;
  }

  private int[] oNSolution(int[] nums) {
    Set<Integer> visited = new HashSet<>();
    for (int i : nums) {
      if (visited.contains(i)) {
        visited.remove(i);
      } else {
        visited.add(i);
      }
    }
    final int[] result = new int[visited.size()];
    int index = 0;
    for (int i : visited) {
      result[index++] = i;
    }
    return result;
  }

  public static void main(String[] args) {
    int a = 0b0;
    a ^= 0b1;
    a ^= 2; // 0b0010
    a ^= 0b1;
    a ^= 4;
    a ^= 5; // 0b0101
    a ^= 4;

    System.out.println(2 ^ 5);
    System.out.println(a & -a);
  }
}
