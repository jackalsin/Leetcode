package _351_400._368_Largest_Divisible_Subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  /**
   * This uses O(N^2), O(N) solution.
   *
   * @param nums
   * @return
   */
  public List<Integer> largestDivisibleSubset(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums == null || nums.length < 1) {
      return result;
    }
    final int[] divCounts = new int[nums.length];
    final int[] parents = new int[nums.length];
    Arrays.fill(parents, -1);
    Arrays.fill(divCounts, 1);
    Arrays.sort(nums);
    int maxSize = 1, maxSizeIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] % nums[j] == 0) {
          if (divCounts[i] <= divCounts[j] + 1) {
            divCounts[i] = divCounts[j] + 1;
            parents[i] = j;
          }
        }
        if (maxSize < divCounts[i]) {
          maxSize = divCounts[i];
          maxSizeIndex = i;
        }
      }
    }
    while (maxSizeIndex != -1) {
      result.add(nums[maxSizeIndex]);
      maxSizeIndex = parents[maxSizeIndex];
    }
    return result;
  }

}
