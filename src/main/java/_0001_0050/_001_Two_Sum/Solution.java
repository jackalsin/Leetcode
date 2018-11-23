package _0001_0050._001_Two_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2017/1/6.
 */
public class Solution {

  public int[] twoSum(int[] nums, int target) {
    int[] result = new int[]{0, 0};
    if (nums == null || nums.length <= 1) {
      return result;
    } else {
      Map<Integer, Integer> originalIndex = new HashMap<>();
      for (int head = 0; head < nums.length; head++) {
        int toFind = target - nums[head];
        if (originalIndex.containsKey(toFind)) {
          result[0] = originalIndex.get(toFind);
          result[1] = head;
        }
        originalIndex.put(nums[head], head);
      }
      return result;
    }
  }
}
