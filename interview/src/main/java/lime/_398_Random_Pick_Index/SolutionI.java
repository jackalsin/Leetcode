package lime._398_Random_Pick_Index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 4/7/2021
 */
public final class SolutionI implements Solution {
  private final Random rand = new Random();
  private final Map<Integer, List<Integer>> valToIndex = new HashMap<>();

  public SolutionI(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      valToIndex.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    final List<Integer> index = valToIndex.get(target);
    assert index != null;
    return index.get(rand.nextInt(index.size()));
  }
}
