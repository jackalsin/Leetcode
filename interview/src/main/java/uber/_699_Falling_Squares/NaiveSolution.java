package uber._699_Falling_Squares;

import java.util.ArrayList;
import java.util.List;

public class NaiveSolution {

  /**
   * Time Complexity O(N^2)
   *
   * @param positions
   * @return
   */
  public List<Integer> fallingSquares(int[][] positions) {
    final List<Integer> result = new ArrayList<>();
    int maxHeight = 0;
    final List<Interval> heights = new ArrayList<>();
    for (final int[] pos : positions) {
      int curMax = insert(heights, pos);
      maxHeight = Math.max(maxHeight, curMax);
      result.add(maxHeight);
    }
    return result;
  }

  /**
   * @param heights
   * @param pos     {start, length}
   * @return
   */
  private int insert(List<Interval> heights, int[] pos) {
    int max = 0;
    for (final Interval i : heights) {
      if (i.start > pos[0] + pos[1] - 1 || i.end < pos[0]) continue;
      max = Math.max(max, i.height);
    }

    max += pos[1];
    heights.add(new Interval(pos[0], pos[0] + pos[1] - 1, max));
    return max;
  }

  private static final class Interval {
    /* start and end are inclusive */
    private int start, end, height;

    public Interval(int start, int end, int height) {
      this.start = start;
      this.end = end;
      this.height = height;
    }
  }
}
