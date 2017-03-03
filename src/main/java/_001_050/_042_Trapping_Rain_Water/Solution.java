package _001_050._042_Trapping_Rain_Water;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
public class Solution {
  /**
   * Given n non-negative integers representing an elevation map where the width of each bar is 1,
   * compute how much water it is able to trap after raining.
   * @param height
   * @return
   */
  public int trap(int[] height) {
    if (height == null || height.length <= 1) {
      return 0;
    }
    int left = 0, right = height.length - 1;
    int maxLeft = 0, maxRight = 0, result = 0;
    while (left < right) {
      if (height[left] <= height[right]) {
        if (maxLeft < height[left]) {
          maxLeft = height[left];
        } else {
          result += maxLeft - height[left];
        }
        left++;
      } else {
        if (maxRight < height[right]) {
          maxRight = height[right];
        } else {
          result += maxRight - height[right];
        }
        right--;
      }
    }
    return result;
  }
}
