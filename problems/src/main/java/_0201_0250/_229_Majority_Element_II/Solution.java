package _0201_0250._229_Majority_Element_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class Solution {
  public List<Integer> majorityElement(int[] nums) {
    int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
    List<Integer> result = new ArrayList<>();
    for (int i : nums) {
      if (candidate1 == i) {
        count1++;
      } else if (candidate2 == i) {
        count2++;
      } else if (count1 == 0) {
        candidate1 = i;
        count1++;
      } else if (count2 == 0) {
        candidate2 = i;
        count2++;
      } else {
        --count1;
        --count2;
      }
    }
    addCandidateOverLimit(result, nums, candidate1);
    addCandidateOverLimit(result, nums, candidate2);
    return result;
  }

  private static void addCandidateOverLimit(List<Integer> result, int[] nums, final int candidate) {
//    if (Arrays.stream(nums).filter(i -> i == candidate).count() > nums.length / 3) {
//      result.add(candidate);
//    }
    int count = 0;
    for (int i : nums) {
      if (candidate == i) count++;
    }
    if (count > nums.length/3) {
      result.add(candidate);
    }
  }
}
