package _701_750._747_Largest_Number_At_Least_Twice_of_Others;

public class Solution {
  public int dominantIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    int maxIndex = 0, max = nums[0], secondMaxIndex = -1, secondMax = Integer.MIN_VALUE;
    for (int i = 1; i < nums.length; i++) {
      if (max < nums[i]) {
        secondMaxIndex = maxIndex;
        secondMax = max;

        maxIndex = i;
        max = nums[i];
      } else if (nums[i] > secondMax) {
        secondMaxIndex = i;
        secondMax = nums[i];
      }
    }
    if (secondMaxIndex == -1) {
      return maxIndex; // only one element
    } else {
      return max >= secondMax * 2 ? maxIndex : -1;
    }
  }
}
