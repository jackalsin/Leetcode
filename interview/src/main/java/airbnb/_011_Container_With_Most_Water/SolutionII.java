package airbnb._011_Container_With_Most_Water;

public final class SolutionII implements Solution {
  public int maxArea(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int maxArea = 0, left = 0, right = height.length - 1;
    while (left < right) {
      final int leftHeight = height[left], rightHeight = height[right];
      maxArea = Math.max(maxArea, Math.min(leftHeight, rightHeight) * (right - left));
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return maxArea;
  }
}
