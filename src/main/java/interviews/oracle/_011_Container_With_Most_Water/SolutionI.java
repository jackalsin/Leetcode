package interviews.oracle._011_Container_With_Most_Water;

/**
 * @author jacka
 * @version 1.0 on 11/3/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int maxArea(int[] height) {
    int max = 0;
    if (height == null || height.length == 0) {
      return max;
    }
    final int n = height.length;
    for (int left = 0, right = n - 1; left < right; ) {
      final int h = Math.min(height[left], height[right]);
      max = Math.max(max, h * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return max;
  }
}
