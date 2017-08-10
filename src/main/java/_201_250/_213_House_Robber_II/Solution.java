package _201_250._213_House_Robber_II;

/**
 * @author jacka
 * @version 1.0 on 8/9/2017.
 */
public class Solution {
  public int rob(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int max = 0, len = nums.length;
    for(int start = 0; start < nums.length; ++start) {
      int prevMax = nums[start], prevPrevMax = 0;
      for(int i = start == len - 1 ? 0 : start + 1; i != start; ++i) {
        int preIndex = i == 0 ? nums.length - 1 : i - 1;
        // if is a neighbor with prev prev, cannot steal
        int steal = isNeighborWithPrevPrev(i, len) ? prevPrevMax : Math.max(prevPrevMax + nums[i],
            prevMax - nums[preIndex] + nums[i]);
        int curMax = Math.max(steal, prevMax);
        prevPrevMax = prevMax;
        prevMax = curMax;
        if (i == nums.length - 1) {
          i = -1;
        }
      }
      max = Math.max(max, prevMax);
    }
    return max;
  }

  private static int getPrevNeighbor(int index, final int len) {
    return index == 0 ? len - 1 : index - 1;
  }
  private static boolean isNeighborWithPrevPrev(int index, final int len) {
    int prev = getPrevNeighbor(index, len);
    int prevPrev = getPrevNeighbor(prev, len);
    return index == getPrevNeighbor(prevPrev, len);
  }


}
