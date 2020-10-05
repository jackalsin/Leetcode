package uber._042_Trapping_Rain_Water;

public class Solution {
  public int trap(int[] height) {
    if (height == null || height.length == 0) {
      return 0;
    }

    int res = 0, left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0;
    while (left <= right) {
      if (height[left] <= height[right]) {
        res += Math.max(0, maxLeft - height[left]);
        maxLeft = Math.max(maxLeft, height[left]);
        left++;
      } else {
        res += Math.max(0, maxRight - height[right]);
        maxRight = Math.max(maxRight, height[right]);
        right--;
      }
    }
    return res;
  }
}
