package microsoft._162_Find_Peak_Element;

public class Solution {
  public int findPeakElement(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0; // illegal
    }

//    assert nums.length > 1;
    int left = 0, right = nums.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left, nextMid = mid + 1;
      if (nums[mid] < nums[nextMid]) {
        left = nextMid;
      } else {
        right = mid;
      }
    }
    return left;
  }

}
