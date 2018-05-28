package _501_550._523_Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  /**
   * Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous
   * subarray of size at least 2 that sums up to the multiple of k, that is, sums up to n*k where n is also an integer.
   * <p>
   * Time Complexity: O9N)
   * Space Complexity: O(K)
   * 75 / 75 test cases passed.
   * Status: Accepted
   * Runtime: 14 ms
   *
   * @param nums
   * @param k
   * @return
   */
  public boolean checkSubarraySum(int[] nums, int k) {
    final Map<Integer, Integer> reminderExist = new HashMap<>();
    int sum = 0;
    reminderExist.put(0, -1);
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      sum += num;
      final int remainder = k == 0 ? sum : ((sum % k + Math.abs(k)) % Math.abs(k));
      if (reminderExist.containsKey(remainder) && i - reminderExist.get(remainder) >= 2) {
        return true;
      } else {
        reminderExist.putIfAbsent(remainder, i);
      }
    }
    return false;
  }
}
