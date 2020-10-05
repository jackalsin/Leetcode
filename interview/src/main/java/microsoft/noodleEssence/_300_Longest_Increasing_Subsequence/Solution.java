package microsoft.noodleEssence._300_Longest_Increasing_Subsequence;

public class Solution {

  public int lengthOfLIS(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    // size - 1
    final int[] tails = new int[nums.length];
    int end = 0;
    tails[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      int left = 0, right = end;
      final int num = nums[i];
      // find the first greater than or equals to
      while (left < right) {
        final int mid = (right - left) / 2 + left;
        if (tails[mid] >= num) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      if (tails[left] < num) { // all elements are greater than num
        end++;
        left = end;
      }
      tails[left] = num;
    }
//    System.out.println(Arrays.toString(tails));
    return end + 1;
  }
}
