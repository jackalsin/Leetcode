package interviews.oracle._011_Container_With_Most_Water;

/**
 * @author jacka
 * @version 1.0 on 11/27/2019
 */
public final class SolutionII implements Solution {
  @Override
  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int left = 0, right = height.length - 1,
        maxArea = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        final int curArea = height[left] * (right - left);
        maxArea = Math.max(curArea, maxArea);
        left++;
      } else {
        final int curArea = height[right] * (right - left);
        maxArea = Math.max(curArea, maxArea);
        right--;
      }
    }
    return maxArea;
  }
}
