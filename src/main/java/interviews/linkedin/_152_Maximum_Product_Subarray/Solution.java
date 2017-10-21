package interviews.linkedin._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public class Solution {
  public int maxProduct(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxEndHere = nums[0], minEndHere = nums[0], maxSoFar = nums[0];
    for (int i = 1; i < nums.length; ++i) {
      int num = nums[i], preMaxEndHere = maxEndHere, preMinEndHere = minEndHere;
      maxEndHere = Math.max(Math.max(preMaxEndHere * num, preMinEndHere * num), num);
      minEndHere = Math.min(Math.min(preMaxEndHere * num, preMinEndHere * num), num);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
