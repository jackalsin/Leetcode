package airbnb._042_Trapping_Rain_Water;

/**
 * @author jacka
 * @version 1.0 on 8/17/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int trap(int[] height) {
    if (height == null || height.length == 0) return 0;
    final int len = height.length;
    int left = 0, right = len - 1, res = 0,
        maxLeftHeight = 0, maxRightHeight = 0;
    while (left < right) {
      final int toAdd;
      if (height[right] >= height[left]) {
        maxLeftHeight = Math.max(maxLeftHeight, height[left]);
        toAdd = maxLeftHeight - height[left];
        left++;
      } else {
        maxRightHeight = Math.max(maxRightHeight, height[right]);
        toAdd = maxRightHeight - height[right];
        right--;
      }
      res += toAdd;
    }
    return res;
  }
}
