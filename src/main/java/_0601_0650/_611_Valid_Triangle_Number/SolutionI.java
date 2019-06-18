package _0601_0650._611_Valid_Triangle_Number;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 6/18/2019
 */
public final class SolutionI implements Solution {

  @Override
  public int triangleNumber(int[] nums) {
    int result = 0;
    Arrays.sort(nums);
    for (int right = nums.length - 1; right >= 2; right--) {
      int left = 0, mid = right - 1;
      while (left < mid) {
        if (nums[left] + nums[mid] > nums[right]) {
//        result += mid - (left + 1) + 1;
          result += mid - left;
          mid--;
        } else {
          left++;
        }
      }
    }
    return result;
  }
}
