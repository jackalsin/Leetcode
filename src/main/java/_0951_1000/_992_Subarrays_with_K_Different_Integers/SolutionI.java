package _0951_1000._992_Subarrays_with_K_Different_Integers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 3/13/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int subarraysWithKDistinct(final int[] nums, final int K) {
    if (nums == null) {
      return 0;
    }
    /*
    假设每个valid array用 [i, j] inclusive 表示
    那么对于每一个j，都有 [i_start, i_end] 区间，每一个都是valid case
     */
    final int len = nums.length;
    int leftStart = 0, leftEnd = 0, result = 0;
    final Window leftStartWindow = new Window(),
        leftEndWindow = new Window();
    for (int i = 0; i < len; i++) {
      final int num = nums[i];
      leftStartWindow.add(num);
      leftEndWindow.add(num);

      while (leftStartWindow.size() > K) {
        leftStartWindow.remove(nums[leftStart++]);
      }
      while (leftEndWindow.size() >= K) {
        leftEndWindow.remove(nums[leftEnd++]);
      }
      result += leftEnd - leftStart;
    }
    return result;
  }

  private static final class Window {
    private final Map<Integer, Integer> counts = new HashMap<>();

    private void add(int num) {
      counts.put(num, counts.getOrDefault(num, 0) + 1);
    }

    private void remove(int num) {
      final int prev = counts.get(num);
      if (prev == 1) {
        counts.remove(num);
      } else {
        counts.put(num, prev - 1);
      }
    }

    private int size() {
      return counts.size();
    }
  }
}
