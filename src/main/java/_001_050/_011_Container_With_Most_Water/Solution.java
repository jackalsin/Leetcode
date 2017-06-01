package _001_050._011_Container_With_Most_Water;

/**
 * Implementation notes:
 * Using a left and a right pointer to point the start and the end of the array. Then, we will
 * get a {@code maxWater}. When we move the pointers, the length will be shorter, so we need to
 * make {@code curHeight} higher.
 *
 * @author jacka
 * @version 1.0 on 2017/1/18.
 */
public class Solution {
  /**
   * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate
   * (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and
   * (i, 0). Find two lines, which together with x-axis forms a container, such that the container
   * contains the most water.
   *
   * Note: You may not slant the container and n is at least 2.
   *
   * @param height an array that indicates the heights, {@code heights.length >= 2}
   * @return the maxArea surround by the start side, the end side and the x-axis.
   */
  public int maxArea(int[] height) {
    int maxWater = 0, curHeight = 0, left = 0, right = height.length - 1;
    while (left < right) {
      curHeight = Math.min(height[left], height[right]);
      maxWater = Math.max(maxWater, (right - left) * curHeight);
      while (height[left] <= curHeight && left < right) {
        left++;
      }
      while (height[right] <= curHeight && left < right) {
        right--;
      }
    }
    return maxWater;
  }
}
