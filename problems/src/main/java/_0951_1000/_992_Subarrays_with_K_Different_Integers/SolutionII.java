package _0951_1000._992_Subarrays_with_K_Different_Integers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 10/15/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int subarraysWithKDistinct(int[] A, int K) {
    int leftStart = 0, leftEnd = 0, result = 0;
    final Window leftStartWindow = new Window(),
        leftEndWindow = new Window();
    for (int a : A) {
      leftStartWindow.add(a);
      leftEndWindow.add(a);

      while (leftStartWindow.size() > K) {
        leftStartWindow.remove(A[leftStart++]);
      }
      while (leftEndWindow.size() >= K) {
        leftEndWindow.remove(A[leftEnd++]);
      }
      result += leftEnd - leftStart;
    }
    return result;
  }

  private static final class Window {
    private final Map<Integer, Integer> countMap = new HashMap<>();

    private void add(final int num) {
      countMap.put(num, countMap.getOrDefault(num, 0) + 1);
    }

    private void remove(final int num) {
      final Integer count = countMap.get(num);
      assert count != null;
      if (count == 1) {
        countMap.remove(num);
      } else {
        countMap.put(num, count - 1);
      }
    }

    private int size() {
      return countMap.size();
    }
  }
}
