package _0301_0350._330_Patching_Array;

/**
 * @author jacka
 * @version 1.0 on 9/29/2017.
 */
public class Solution {
  /**
   * Original Post:
   * https://discuss.leetcode.com/topic/35494/solution-explanation
   * <p>
   * My Example:
   * https://onedrive.live.com/edit.aspx/Documents/%e8%ae%a1%e7%ae%97%e6%9c%ba?cid=45bb4ddfb385cc9d&id=documents&wd=target%28Leetcode.one%7C2F83A2CA-D1A8-46A7-B25A-212DEA37C568%2F330.%20Patching%20Array%7CDCF1AB7E-218B-46BE-BCBC-E7098969B8BC%2F%29
   * onenote:https://d.docs.live.net/45bb4ddfb385cc9d/Documents/计算机/Leetcode.one#330.%20Patching%20Array%20&section-id={2F83A2CA-D1A8-46A7-B25A-212DEA37C568}&page-id={DCF1AB7E-218B-46BE-BCBC-E7098969B8BC}&end
   *
   * @param nums
   * @param n
   * @return
   */
  public int minPatches(int[] nums, int n) {
    int count = 0, i = 0;
    /* smallest possible missing number starting with 0 */
    long possibleMiss = 1;
    while (possibleMiss <= n) {
      if (i < nums.length && nums[i] <= possibleMiss) {
        possibleMiss += nums[i++];
      } else {
        count++;
        possibleMiss += possibleMiss; // add possibleMiss to the necessary array;
      }
    }
    return count;
  }
}
