package linkedin._352_Data_Stream_as_Disjoint_Intervals;

import definition.Interval;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/15/18
 */
public final class SolutionI implements SummaryRanges {
  private final TreeSet<Interval> treeSet = new TreeSet<>(new Comparator<Interval>() {

    @Override
    public int compare(Interval o1, Interval o2) {
      return Integer.compare(o1.start, o2.start);
    }

  });

  @Override
  public void addNum(int val) {
    final Interval tmp = new Interval(val, val), prev = treeSet.floor(tmp), next = treeSet.ceiling(tmp);

    boolean isMerged = false;
    if (prev != null && prev.end + 1 >= val) {
      prev.end = Math.max(prev.end, val);
      isMerged = true;
    }

    if (next != null && next.start - 1 <= val) {
      next.start = Math.min(next.start, val);
      isMerged = true;
    }

    if (prev != null && next != null && prev.end >= next.start - 1) {
      prev.end = Math.max(next.end, prev.end);
      prev.start = Math.min(next.start, prev.start);
      if (prev != next) { // if next and prev are the same, it will remove both. Don't do it.
        treeSet.remove(next);
      }
    }

    if (!isMerged) {
      treeSet.add(tmp);
    }

  }

  @Override
  public int[][] getIntervals() {
    final int[][] res = new int[treeSet.size()][2];
    int i = 0;
    for (final Interval e : treeSet) {
      res[i][0] = e.start;
      res[i][1] = e.end;
      ++i;
    }
    return res;
  }
}
