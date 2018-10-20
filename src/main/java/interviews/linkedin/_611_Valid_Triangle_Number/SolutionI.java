package interviews.linkedin._611_Valid_Triangle_Number;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/5/18
 */
public final class SolutionI implements Solution {
  public int triangleNumber(int[] nums) {
    int count = 0;
    for (int k = nums.length - 1; k >= 0; --k) {
      int i = 0, j = k - 1;
      while (i < j) {
        if (nums[i] + nums[j] > nums[k]) {
          count += j - i;
          j--;
        } else {
          i++;
        }
      }
    }
    return count;
  }

}
