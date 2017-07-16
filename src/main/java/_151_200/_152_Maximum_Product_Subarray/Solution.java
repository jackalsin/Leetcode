package _151_200._152_Maximum_Product_Subarray;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class Solution {
  public int maxProduct(int[] nums) {
    int maxSoFar = nums[0];
    int maxHere = nums[0];
    int minHere = nums[0];

    for (int i = 1; i < nums.length; i++) {
      int preMax = maxHere; // backup
      maxHere = Math.max(Math.max(maxHere * nums[i], minHere * nums[i]), nums[i]);
      minHere = Math.min(Math.min(preMax * nums[i], minHere * nums[i]), nums[i]);
      maxSoFar = Math.max(maxSoFar, maxHere);
    }
    return maxSoFar;
  }
}
