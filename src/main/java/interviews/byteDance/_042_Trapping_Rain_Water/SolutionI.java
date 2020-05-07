package interviews.byteDance._042_Trapping_Rain_Water;

/**
 * @author jacka
 * @version 1.0 on 5/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }
    int max = 0;
    for (int left = 0, right = height.length - 1, leftHeight = height[left], rightHeight = height[right];
         left <= right;
    ) {
      if (height[left] <= height[right]) {
        if (leftHeight > height[left]) {
          max += leftHeight - height[left];
        } else {
          leftHeight = height[left];
        }
        left++;
      } else {
        if (rightHeight > height[right]) {
          max += rightHeight - height[right];
        } else {
          rightHeight = height[right];
        }
        right--;
      }
    }
    return max;
  }
}
