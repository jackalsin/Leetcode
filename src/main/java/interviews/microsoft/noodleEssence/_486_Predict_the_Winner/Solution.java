package interviews.microsoft.noodleEssence._486_Predict_the_Winner;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
  public boolean PredictTheWinner(int[] nums) {
    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    final Map<Tuple, Integer> cache = new HashMap<>();
    return maxGet(nums, cache, 0, nums.length - 1, sum) >= ((sum + 1) / 2);
  }

  private int maxGet(final int[] nums, final Map<Tuple, Integer> cache, int start, int end, final int remain) {
    final Tuple key = new Tuple(start, end);
    if (cache.containsKey(key)) {
      return cache.get(key);
    }
    if (start == end) {
      cache.put(key, nums[start]);
      return nums[start];
    }
    final int left = maxGet(nums, cache, start + 1, end, remain - nums[start]),
        right = maxGet(nums, cache, start, end - 1, remain - nums[end]);

    final int pickLeft = (remain - left), pickRight = remain - right, max = Math.max(pickLeft, pickRight);
    cache.put(key, max);
    return max;
  }


  private static final class Tuple {
    private final int start, end;

    public Tuple(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Tuple tuple = (Tuple) o;
      return start == tuple.start &&
          end == tuple.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(start, end);
    }

    @Override
    public String toString() {
      return "Tuple{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }
}
