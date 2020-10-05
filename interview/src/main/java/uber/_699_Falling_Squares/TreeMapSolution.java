package uber._699_Falling_Squares;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public final class TreeMapSolution implements Solution {
  private static final int DUMMY_VALUE = 23333;

  @Override
  public List<Integer> fallingSquares(int[][] positions) {
    final TreeSet<Interval> treeSet = new TreeSet<>((x1, x2) -> Integer.compare(x1.start, x2.start));
    treeSet.add(new Interval(0, 1_000_000_000, 0));
    final List<Integer> result = new ArrayList<>();
    int maxHeight = 0;
    for (final int[] pos : positions) {
      final int left = pos[0], right = pos[0] + pos[1] - 1;
      final Interval startInterval = treeSet.floor(new Interval(left, right, -1));
      // using floor, which includes equals, startEntry should not be null
      assert startInterval != null;
      treeSet.remove(startInterval);
      if (startInterval.start < left) {
        treeSet.add(new Interval(startInterval.start, left - 1, startInterval.height));
      }
      treeSet.add(new Interval(left, startInterval.end, startInterval.height));
      int curHeight = startInterval.height;
      Interval curInterval = treeSet.ceiling(new Interval(left, DUMMY_VALUE, DUMMY_VALUE));
      assert curInterval != null;
      while (curInterval != null && curInterval.end <= right) {
        treeSet.remove(curInterval);
        curHeight = Math.max(curHeight, curInterval.height);
        curInterval = treeSet.ceiling(new Interval(left, DUMMY_VALUE, DUMMY_VALUE));
      }

      if (curInterval != null && right >= curInterval.start && right < curInterval.end) {
        treeSet.remove(curInterval);
        curHeight = Math.max(curHeight, curInterval.height);
        treeSet.add(new Interval(right + 1, curInterval.end, curInterval.height));
      }

      // add new interval
      curHeight += pos[1];
      maxHeight = Math.max(curHeight, maxHeight);
      result.add(maxHeight);
      treeSet.add(new Interval(left, right, curHeight));
    }

    return result;
  }

  private static final class Interval {
    private final int start, end, height;

    private Interval(int start, int end, int height) {
      this.start = start;
      this.end = end;
      this.height = height;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Interval interval = (Interval) o;
      return start == interval.start &&
          end == interval.end &&
          height == interval.height;
    }

    @Override
    public int hashCode() {
      return Objects.hash(start, end, height);
    }

    @Override
    public String toString() {
      return "Interval{" +
          "start=" + start +
          ", end=" + end +
          ", height=" + height +
          '}';
    }
  }
}
