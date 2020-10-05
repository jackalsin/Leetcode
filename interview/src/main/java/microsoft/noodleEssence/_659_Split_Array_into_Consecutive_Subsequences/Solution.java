package microsoft.noodleEssence._659_Split_Array_into_Consecutive_Subsequences;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public boolean isPossible(int[] nums) {
    final Map<Integer, Integer> charCounts = new HashMap<>(),
        tailCounts = new HashMap<>();
    for (int num : nums) {
      charCounts.put(num, charCounts.getOrDefault(num, 0) + 1);
    }

    int i = 0;
    for (int num : nums) {
      final int count = charCounts.get(num);
      if (count == 0) continue;
      final int nextCount = charCounts.getOrDefault(num + 1, 0),
          nextNextCount = charCounts.getOrDefault(num + 2, 0);
      if (tailCounts.getOrDefault(num, 0) != 0) {
        charCounts.put(num, count - 1);
        tailCounts.put(num, tailCounts.get(num) - 1);
        tailCounts.put(num + 1, tailCounts.getOrDefault(num + 1, 0) + 1);

      } else if (nextCount != 0 && nextNextCount != 0) {
        charCounts.put(num, count - 1);
        charCounts.put(num + 1, nextCount - 1);
        charCounts.put(num + 2, nextNextCount - 1);
        tailCounts.put(num + 3, tailCounts.getOrDefault(num + 3, 0) + 1);
      } else {
        return false;
      }

    }
    return true;
  }
}
