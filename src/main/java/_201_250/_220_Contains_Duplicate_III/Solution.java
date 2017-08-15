package _201_250._220_Contains_Duplicate_III;

import sun.reflect.generics.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/14/2017.
 */
public class Solution {
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
  public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    if (k <= 0 || nums == null || nums.length < 2) {
      return false;
    }
    TreeSet<Integer> valsInK = new TreeSet<>();
    valsInK.add(nums[0]);
    for (int i = 1; i < nums.length; ++i) {
      valsInK.add(nums[i]);
      if (i > k) {
        valsInK.remove(nums[i - k - 1]);
      }
      int min = valsInK.first();
      int max = valsInK.last();
      if (max - min > t) {
        return false;
      }
    }
    return true;
  }
}
