package interviews.linkedin._352_Data_Stream_as_Disjoint_Intervals;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 8/12/2019
 */
public final class SolutionII implements SummaryRanges {
  private final TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[0], o2[0]);
    }
  });

  public void addNum(int val) {
    final int[] key = new int[]{val, val}, prev = treeSet.floor(key),
        next = treeSet.ceiling(key), newInterval = {val, val};
    if (prev != null && prev[0] <= val && val <= prev[1]) return; // skip if already in the entry
    if (prev != null && prev[1] == val - 1) {
      treeSet.remove(prev);
      newInterval[0] = prev[0];
    }

    if (next != null && next[0] == val + 1) {
      treeSet.remove(next);
      newInterval[1] = next[1];
    }
    treeSet.add(newInterval);
  }

  public int[][] getIntervals() {
    final int[][] res = new int[treeSet.size()][2];
    int i = 0;
    for (final int[] e : treeSet) {
      res[i][0] = e[0];
      res[i][1] = e[1];
      ++i;
    }
    return res;
  }
}
