package interviews.google._540_Single_Element_in_a_Sorted_Array;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
public class Solution {
  /**
   * Time Complexity O(Log N)
   *
   * 7 / 7 test cases passed.
   * Status: Accepted
   * Runtime: 2 ms
   * www.1point3acres.com/bbs/thread-344769-1-1.html
   * int array, 所有數字都連著出現兩次，只有一個數字出現一次。找出只有一次的數字 鏉ユ簮涓€
   */
  public int singleNonDuplicate(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (right - left) / 2 + left;
      if (mid % 2 == 1) {
        mid--;
      }

      if (nums[mid] == nums[mid + 1]) {
        left = mid + 2;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

}
