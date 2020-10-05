package _0701_0750._715_Range_Module;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public final class TreeSetSolution implements Solution {
  private final TreeSet<Interval> ranges = new TreeSet<>(new Comparator<Interval>() {
    @Override
    public int compare(Interval o1, Interval o2) {
      return Integer.compare(o1.end, o2.end);
    }
  });

  public void addRange(int left, int right) {
    right--;
    Iterator<Interval> itr = ranges.tailSet(new Interval(0, left - 1)).iterator();
    while (itr.hasNext()) {
      Interval iv = itr.next();
      if (right + 1 < iv.start) break;
      left = Math.min(left, iv.start);
      right = Math.max(right, iv.end);
      itr.remove();
    }
    ranges.add(new Interval(left, right));
  }

  public boolean queryRange(int left, int right) {
    right--;
    Interval iv = ranges.ceiling(new Interval(0, left));
    return (iv != null && iv.start <= left && right <= iv.end);
  }

  public void removeRange(int left, int right) {
    right--;
    Iterator<Interval> itr = ranges.tailSet(new Interval(0, left)).iterator();
    final List<Interval> todo = new ArrayList<>();
    while (itr.hasNext()) {
      Interval iv = itr.next();
      if (right + 1 < iv.start) break;
      if (iv.start < left) todo.add(new Interval(iv.start, left - 1));
      if (right < iv.end) todo.add(new Interval(right + 1, iv.end));
      itr.remove();
    }
    ranges.addAll(todo);
  }

  @Override
  public String toString() {
    return "TreeSetSolution{" +
        "ranges=" + ranges +
        '}';
  }

  private static final class Interval {
    private int start, end;

    private Interval(int start, int end) {
      this.start = start;
      this.end = end;
    }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          '}';
    }
  }

}
