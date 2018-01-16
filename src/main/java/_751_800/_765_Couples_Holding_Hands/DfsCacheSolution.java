package _751_800._765_Couples_Holding_Hands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity O(2^N)
 */
public final class DfsCacheSolution implements Solution {

  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  public int minSwapsCouples(int[] row) {
    final int[] index = new int[row.length];
    final List<Integer> rowList = new ArrayList<>();
    for (int i = 0; i < row.length; i++) {
      index[row[i]] = i;
      rowList.add(row[i]);
    }

    int res = dfs(rowList, index, 0);
    System.out.println(cache.size());
    return res;
  }

  private int dfs(final List<Integer> row, int[] index, int startIndex) {
    if (startIndex == row.size()) {
      return 0;
    }
    final List<Integer> key = new ArrayList<>(row.subList(startIndex, row.size()));
    if (cache.containsKey(key)) {
      return cache.get(key);
    }

    if (getCouple(row.get(startIndex)) == row.get(startIndex + 1)) {
      int actual = dfs(row, index, startIndex + 2);
      cache.put(key, actual);
      return actual;
    } else {
      int min = Integer.MAX_VALUE;
      // swap row[startIndex + 1] And row[coupleIndex]
      int couple = getCouple(row.get(startIndex)), coupleIndex = index[couple], swapVal =
          row.get(startIndex + 1);
      swap(row, startIndex + 1, coupleIndex);
      index[couple] = startIndex + 1;
      index[swapVal] = coupleIndex;
      min = Math.min(min, dfs(row, index, startIndex + 2) + 1);
      swap(row, startIndex + 1, coupleIndex);
      index[couple] = coupleIndex;
      index[swapVal] = startIndex + 1;


      couple = getCouple(row.get(startIndex + 1));
      coupleIndex = index[couple];
      swapVal = row.get(startIndex);
      swap(row, startIndex, coupleIndex);
      index[couple] = startIndex;
      index[swapVal] = coupleIndex;

      min = Math.min(min, dfs(row, index, startIndex + 2) + 1);

      swap(row, startIndex, coupleIndex);
      index[couple] = coupleIndex;
      index[swapVal] = startIndex;
      cache.put(key, min);
      return min;
    }
  }

  private void swap(final List<Integer> row, int i, int j) {
    int tmp = row.get(i);
    row.set(i, row.get(j));
    row.set(j, tmp);
  }

  private int getCouple(int a) {
    return a % 2 == 0 ? a + 1 : a - 1;
  }

}
