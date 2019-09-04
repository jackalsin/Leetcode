package interviews.linkedin._352_Data_Stream_as_Disjoint_Intervals;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 9/3/2019
 */
public final class SolutionIII implements SummaryRanges {
  private final TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
      return Integer.compare(o1[0], o2[0]);
    }
  });

  public void addNum(int val) {
    final int[] toInsert = {val, val};
    final int[] prev = treeSet.floor(toInsert), next = treeSet.ceiling(toInsert);
    if (prev != null && prev[1] >= val - 1) {
      treeSet.remove(prev);
      toInsert[0] = Math.min(prev[0], toInsert[0]);
      toInsert[1] = Math.max(prev[1], toInsert[1]);
    }

    if (next != null && next[0] <= val + 1) {
      treeSet.remove(next);
      toInsert[0] = Math.min(next[0], toInsert[0]);
      toInsert[1] = Math.max(next[1], toInsert[1]);
    }
    treeSet.add(toInsert);
  }

  public int[][] getIntervals() {
    final int[][] res = new int[treeSet.size()][2];
    int i = 0;
    for (final int[] e : treeSet) {
      res[i][0] = e[0];
      res[i++][1] = e[1];
    }
    return res;
  }
}
