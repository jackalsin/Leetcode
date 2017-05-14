package _051_100._078_subset;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
public class Solution2 {
  public List<List<Integer>> subsets(int[] nums) {
    int total = 1 << nums.length;
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < total; i++) {
      List<Integer> cur = new ArrayList<>();
      for (int j = 0; j < nums.length; j++) {
        if ((1 & (i >> j)) == 1) { //真他妈危险
          cur.add(nums[j]);
        }
      }
      result.add(cur);
    }
    return result;
  }
}
