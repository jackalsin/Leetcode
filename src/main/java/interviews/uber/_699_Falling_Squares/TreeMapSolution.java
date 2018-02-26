package interviews.uber._699_Falling_Squares;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class TreeMapSolution implements Solution {

  @Override
  public List<Integer> fallingSquares(int[][] positions) {
    final TreeMap<int[], Integer> map = new TreeMap<>((x, y) -> {
      return Integer.compare(x[0], y[0]);
    });
    map.put(new int[]{0, 1_000_000_000}, 0);
    final List<Integer> result = new ArrayList<>();
    int maxHeight = 0;
    for (final int[] pos : positions) {
      final int left = pos[0], len = pos[1];
      final int[] newKey = new int[]{left, left + len - 1};
      final Map.Entry<int[], Integer> startEntry = map.floorEntry(newKey);
      if (startEntry == null) {
        // shouldn't arrive here
        map.put(newKey, len);
        maxHeight = Math.max(maxHeight, len);
      } else {
        map.remove(startEntry.getKey());
        // startEntry.end <= len + left - 1
        if (newKey[0] > startEntry.getKey()[0]) {
          map.put(new int[]{startEntry.getKey()[0], newKey[0] - 1}, startEntry.getValue());
          map.put(new int[]{newKey[0], startEntry.getKey()[1]}, startEntry.getValue());
        }
        Map.Entry<int[], Integer> curEntry = map.ceilingEntry(new int[]{newKey[0], startEntry.getKey()[1]});
        int curHeight = startEntry.getValue();
        while (curEntry != null && curEntry.getKey()[0] <= newKey[1]) { // reconsider
          map.remove(curEntry.getKey());
          curHeight = Math.max(curHeight, curEntry.getValue());
          curEntry = map.ceilingEntry(new int[]{newKey[0]});
        }

        if (curEntry != null && curEntry.getKey()[1] < curEntry.getKey()[1]) {
          map.put(new int[]{curEntry.getKey()[1] + 1, curEntry.getKey()[1]}, curEntry.getValue());
        }
        curHeight += len;
        maxHeight = Math.max(maxHeight, curHeight);
        map.put(newKey, curHeight);
      }
      result.add(maxHeight);
      // add assert checking the continuous interval.
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
  }
}
