package interviews.linkedin._352_Data_Stream_as_Disjoint_Intervals;

import utils.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
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
  public List<Interval> getIntervals() {
    return new ArrayList<>(treeSet);
  }
}
