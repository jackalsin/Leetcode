package _0201_0250._220_Contains_Duplicate_III;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/14/2017.
 */
public interface Solution {
  /**
   * To find out if two distinct indices <code>i</code> and <code>j</code> in the array such that
   * the absolute difference between <code>nums[i]</code> and <code>nums[j]</code> is at most t
   * and the absolute difference between <code>i</code> and <code>j</code> is at most <code>k</code>.
   *
   * @param nums
   * @param k
   * @param t
   * @return
   */
  boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t);
}
