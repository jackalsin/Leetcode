package apple._398_Random_Pick_Index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/28/2021
 */
public final class ReverseMapSolution implements Solution {
  private final Map<Integer, List<Integer>> reverseMap = new HashMap<>();
  private final Random rand = new Random();

  public ReverseMapSolution(int[] nums) {
    for (int i = 0; i < nums.length; ++i) {
      reverseMap.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
    }
  }

  public int pick(int target) {
    final List<Integer> index = reverseMap.get(target);
    assert index != null;
    return index.get(rand.nextInt(index.size()));
  }
}
