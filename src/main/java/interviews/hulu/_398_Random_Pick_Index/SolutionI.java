package interviews.hulu._398_Random_Pick_Index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/7/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, List<Integer>> reversedIndex = new HashMap<>();
  private final Random rand = new Random();

  public SolutionI(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      reversedIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    final List<Integer> index = reversedIndex.get(target);
    return index.get(rand.nextInt(index.size()));
  }
}
