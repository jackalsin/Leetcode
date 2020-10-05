package _0501_0550._506_Relative_Ranks;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSolution implements Solution {
  private static final String GOLD = "Gold Medal";
  private static final String SILVER = "Silver Medal";
  private static final String BRONZE = "Bronze Medal";

  @Override
  public String[] findRelativeRanks(int[] nums) {
    final Map<Integer, Integer> index = new HashMap<>();
    Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return Integer.compare(o2, o1);
      }
    });
    for (int i = 0; i < nums.length; i++) {
      index.put(nums[i], i);
      pq.add(nums[i]);
    }
    final String[] result = new String[nums.length];
    int rank = 0;
    while (!pq.isEmpty()) {
      int score = pq.remove();
      switch (rank) {
        case 0:
          result[index.get(score)] = GOLD;
          break;
        case 1:
          result[index.get(score)] = SILVER;
          break;
        case 2:
          result[index.get(score)] = BRONZE;
          break;
        default:
          result[index.get(score)] = String.valueOf(rank + 1);
      }
      rank++;
    }
    return result;
  }
}
