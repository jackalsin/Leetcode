package _051_100._090_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/30/2017.
 */
public class IterativeSolution {
  /**
   * If we want to insert an element which is a dup, we can only insert it after the newly inserted elements from last step.
   *
   * Explanation:
   *    First: {}, {1}
   *    Second: {}, {1}, {2},{1,2}
   *    Third: Dup is found, add duplicated 2 only to (2), {1,2}
   * @param nums
   * @return
   */
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    int size = 0, startIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      startIndex = (i >= 1 && nums[i] == nums[i - 1]) ? size:0;
      size = result.size();
      for (int j = startIndex; j < size; j++) {
        List<Integer> temp = new ArrayList<>(result.get(j));
        temp.add(nums[i]);
        result.add(temp);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    IterativeSolution solution = new IterativeSolution();
    System.out.println(solution.subsetsWithDup(new int[]{1, 2, 2}));
  }
}
