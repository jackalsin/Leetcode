package _501_550._506_Relative_Ranks;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapSolution implements Solution {
  private static final String GOLD = "Gold Medal";
  private static final String SILVER = "Silver Medal";
  private static final String BRONZE = "Bronze Medal";

  @Override
  public String[] findRelativeRanks(int[] nums) {
    final TreeMap<Integer, Integer> index = new TreeMap<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int i = 0; i < nums.length; i++) {
      index.put(nums[i], i);
    }
    final String[] result = new String[nums.length];
    int rank = 0;
    while (!index.isEmpty()) {
      Map.Entry<Integer, Integer> entry = index.firstEntry();
      index.remove(entry.getKey());
      switch (rank) {
        case 0:
          result[entry.getValue()] = GOLD;
          break;
        case 1:
          result[entry.getValue()] = SILVER;
          break;
        case 2:
          result[entry.getValue()] = BRONZE;
          break;
        default:
          result[entry.getValue()] = String.valueOf(rank + 1);
      }
      rank++;
    }
    return result;
  }
}
