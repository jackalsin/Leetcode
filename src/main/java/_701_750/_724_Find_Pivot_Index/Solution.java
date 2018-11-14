package _701_750._724_Find_Pivot_Index;

public class Solution {

  public int pivotIndex(int[] nums) {
    if (nums == null || nums.length == 0) {
      return -1;
    }
    int sum = 0, leftSum = 0;
    for (int i : nums) sum += i;
    for (int i = 0; i < nums.length; i++) {
      if (leftSum == sum - leftSum - nums[i]) {
        return i;
      }
      leftSum += nums[i];
    }
    return -1;
  }

}
