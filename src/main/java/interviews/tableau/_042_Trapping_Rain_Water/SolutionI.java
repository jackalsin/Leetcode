package interviews.tableau._042_Trapping_Rain_Water;

/**
 * @author jacka
 * @version 1.0 on 2/12/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int trap(int[] height) {
    int sum = 0, maxLeft = 0, maxRight = 0;
    for (int left = 0, right = height.length - 1; left < right; ) {
      if (height[left] < height[right]) {
        if (maxLeft > height[left]) {
          sum += maxLeft - height[left];
        } else {
          maxLeft = height[left];
        }
        left++;
      } else {
        if (maxRight > height[right]) {
          sum += maxRight - height[right];
        } else {
          maxRight = height[right];
        }
        right--;
      }
    }
    return sum;
  }
}
