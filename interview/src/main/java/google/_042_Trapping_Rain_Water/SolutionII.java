package google._042_Trapping_Rain_Water;

/**
 * @author jacka
 * @version 1.0 on 4/20/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int trap(int[] height) {
    int left = 0, right = height.length - 1, maxLeftHeight = 0, maxRightHeight = 0, area = 0;
    while (left < right) {
      final int toAdd;
      if (height[right] >= height[left]) {
        maxLeftHeight = Math.max(maxLeftHeight, height[left]);
        toAdd = Math.max(0, maxLeftHeight - height[left]);
        left++;
      } else {
        maxRightHeight = Math.max(maxRightHeight, height[right]);
        toAdd = Math.max(0, maxRightHeight - height[right]);
        right--;
      }
      area += toAdd;
    }
    return area;
  }
}
