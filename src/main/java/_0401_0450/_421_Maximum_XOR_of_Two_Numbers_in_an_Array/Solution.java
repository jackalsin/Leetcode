package _0401_0450._421_Maximum_XOR_of_Two_Numbers_in_an_Array;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  /**
   * Explanation : https://discuss.leetcode.com/post/166401
   * https://discuss.leetcode.com/post/140533
   *
   * @param nums
   * @return
   */
  public int findMaximumXOR(int[] nums) {
    int mask = 0, max = 0;
    for (int i = 31; i >= 0; i--) {
      mask |= (1 << i);
      Set<Integer> set = new HashSet<>();
      for (int num : nums) {
        set.add(num & mask);
      }

      int candidate = max | (1 << i);
      for (int n : set) {
        if (set.contains(candidate ^ n)) {
          max = candidate;
          break;
        }
      }
    }
    return max;
  }

}
