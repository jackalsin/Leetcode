package _0951_1000._957_Prison_Cells_After_N_Days;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/29/2020
 */
public final class SolutionI implements Solution {
  private static final int OCCUPIED = 1, VACANT = 0;

  public int[] prisonAfterNDays(int[] cells, int N) {
    BitSet curState = new BitSet();
    for (int i = 0; i < cells.length; ++i) {
      curState.set(i, cells[i] == OCCUPIED);
    }
    final List<BitSet> reverseCache = new ArrayList<>();
    final Map<BitSet, Integer> cache = new HashMap<>();
    cache.put(curState, 0);
    reverseCache.add(curState);
    int count = 0;
    for (; count < N; ) {
      final BitSet next = getNext(curState);
      curState = next;
      count++;
      if (cache.containsKey(next)) {
        break; // recur
      }
      cache.put(next, count);
      reverseCache.add(next);
    }
    if (count != N) {
      final int start = cache.get(curState),
          duration = count - start;
      final int index = (N - start) % duration + start;
      curState = reverseCache.get(index);
    }
//    System.out.println(reverseCache);
//    System.out.println(cache);
    final int[] result = new int[8];
    for (int i = 0; i < 8; ++i) {
      if (curState.get(i)) {
        result[i] = 1;
      }
    }
    return result;
  }

  private static BitSet getNext(final BitSet curState) {
    final BitSet result = new BitSet();
    for (int i = 1; i < 7; ++i) {
      if (curState.get(i - 1) == curState.get(i + 1)) {
        result.set(i);
      }
    }
    return result;
  }
}
