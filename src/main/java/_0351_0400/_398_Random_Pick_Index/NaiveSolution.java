package _0351_0400._398_Random_Pick_Index;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 1/11/2018.
 */
public class NaiveSolution implements Solution {
  private final Map<Integer, List<Integer>> valToIndex = new HashMap<>();
  private final Random random = new Random();

  public NaiveSolution(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      valToIndex.putIfAbsent(nums[i], new ArrayList<>());
      valToIndex.get(nums[i]).add(i);
    }
  }

  public int pick(int target) {
    List<Integer> candidates = valToIndex.get(target);
    return candidates.get(random.nextInt(candidates.size()));
  }
}
