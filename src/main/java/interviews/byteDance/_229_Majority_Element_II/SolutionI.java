package interviews.byteDance._229_Majority_Element_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 5/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> majorityElement(int[] nums) {
    int candidate1 = 0, count1 = 0, candidate2 = 1, count2 = 0;
    for (int n : nums) {
      if (n == candidate1) {
        count1++;
      } else if (n == candidate2) {
        count2++;
      } else if (count1 == 0) {
        candidate1 = n;
        count1 = 1;
      } else if (count2 == 0) {
        candidate2 = n;
        count2 = 1;
      } else {
        count1--;
        count2--;
      }
    }
    final List<Integer> result = new ArrayList<>();
    count1 = 0;
    count2 = 0;
    for (int n : nums) {
      if (n == candidate1) count1++;
      if (n == candidate2) count2++;
    }
    if (count1 > nums.length / 3) {
      result.add(candidate1);
    }
    if (count2 > nums.length / 3) {
      result.add(candidate2);
    }
    return result;
  }
}
