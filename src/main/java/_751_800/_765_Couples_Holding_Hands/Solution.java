package _751_800._765_Couples_Holding_Hands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  private int minSwaps = Integer.MAX_VALUE;

  private final Map<List<Integer>, Integer> cache = new HashMap<>();

  public int minSwapsCouples(int[] row) {
    final int[] index = new int[row.length];
    for (int i = 0; i < row.length; i++) {
      index[row[i]] = i;
    }

    dfs(row, index, 0, 0);
    return minSwaps;
  }

  private void dfs(int[] row, int[] index, int startIndex, int curCount) {
    if (startIndex == row.length) {
      minSwaps = Math.min(minSwaps, curCount);
      return;
    }

    if (getCouple(row[startIndex]) == row[startIndex + 1]) {
      dfs(row, index, startIndex + 2, curCount);
    } else {

      // swap row[startIndex + 1] And row[coupleIndex]
      int couple = getCouple(row[startIndex]), coupleIndex = index[couple], swapVal =
          row[startIndex + 1];
      swap(row, startIndex + 1, coupleIndex);
      index[couple] = startIndex + 1;
      index[swapVal] = coupleIndex;
      dfs(row, index, startIndex + 2, curCount + 1);
      swap(row, startIndex + 1, coupleIndex);
      index[couple] = coupleIndex;
      index[swapVal] = startIndex + 1;


      couple = getCouple(row[startIndex + 1]);
      coupleIndex = index[couple];
      swapVal = row[startIndex];
      swap(row, startIndex, coupleIndex);
      index[couple] = startIndex;
      index[swapVal] = coupleIndex;

      dfs(row, index, startIndex + 2, curCount + 1);
      swap(row, startIndex, coupleIndex);
      index[couple] = coupleIndex;
      index[swapVal] = startIndex;
    }
  }

  private void swap(final int[] row, int i, int j) {
    int tmp = row[i];
    row[i] = row[j];
    row[j] = tmp;
  }

  private int getCouple(int a) {
    if (a % 2 == 0) {
      return a + 1;
    } else {
      return a - 1;
    }
  }

}
