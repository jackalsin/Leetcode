package airbnb._011_Container_With_Most_Water;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int maxArea(int[] height) {
    if (height == null || height.length == 0) return 0;
    int maxArea = 0;
    for (int left = 0, right = height.length - 1; left < right; ) {
      final int h = Math.min(height[left], height[right]),
          curArea = h * (right - left);
      maxArea = Math.max(curArea, maxArea);
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}
