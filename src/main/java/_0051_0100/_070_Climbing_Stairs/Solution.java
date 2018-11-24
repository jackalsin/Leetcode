package _0051_0100._070_Climbing_Stairs;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/28/2017.
 */
public class Solution {
  public int climbStairs(int n) {
    int[] array = new int[n + 1];
    array[1] = 1;
    array[0] = 1;
    for (int i = 2; i < n + 1; i++) {
      array[i] = array[i - 1] + array[i - 2];
    }
    return array[n];
  }
}
