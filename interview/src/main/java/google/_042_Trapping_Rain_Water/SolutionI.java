package google._042_Trapping_Rain_Water;

/**
 * @author jacka
 * @version 1.0 on 1/15/2018.
 */
public final class SolutionI implements Solution {
  public int trap(int[] height) {
    int left = 0, right = height.length - 1, leftMaxHeight = 0, rightMaxHeight = 0, area = 0;
    while (left <= right) {
      if (height[left] <= height[right]) {
        area += Math.max(leftMaxHeight - height[left], 0);
        leftMaxHeight = Math.max(leftMaxHeight, height[left]);
        left++;
      } else {
        area += Math.max(0, rightMaxHeight - height[right]);
        rightMaxHeight = Math.max(rightMaxHeight, height[right]);
        right--;
      }
    }
    return area;
  }
}

