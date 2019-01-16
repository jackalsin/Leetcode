package interviews.uber._283_Move_Zeroes;

public class Solution {
  public void moveZeroes(int[] nums) {
    for (int i = 0, j = 0; j < nums.length; j++) {
      if (nums[j] != 0) {
        nums[i] = nums[j];
        if (j != i) {
          nums[j] = 0;
        }
        i++;
      }
    }
  }
}
