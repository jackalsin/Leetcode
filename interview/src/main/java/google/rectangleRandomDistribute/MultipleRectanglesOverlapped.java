package google.rectangleRandomDistribute;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

public final class MultipleRectanglesOverlapped {
  /* Store the max values */
  private final int[] segmentTrees;
  private final int N;
  private int maxArea = 0;
  private final Random random = new Random();

  private final TreeMap<Integer, Interval> intervals = new TreeMap<>();
  private final Map<Integer, Integer> criticalPoints;

  /**
   * The constructor
   *
   * @param rects an array of int array.
   *              Every int array will be [startPoint, endPoint, height].
   *              The end edge  will exclusive,
   *              and the top edge also should be exclusive
   */
  public MultipleRectanglesOverlapped(final int[][] rects) {
    if (rects == null || rects.length == 0) {
      throw new IllegalArgumentException();
    }
    criticalPoints = coordinateCompression(rects);
    this.N = criticalPoints.size();
    final int height = (int) Math.ceil(Math.log(criticalPoints.size()) / Math.log(2)),
        size = 2 * (int) Math.pow(2, height) + 1;
    segmentTrees = new int[size];

    for (final int[] rect : rects) {
      /* start Point, end Point, height */
      update(criticalPoints.get(rect[0]), criticalPoints.get(rect[1]) - 1, rect[2]);
    }

    final List<Interval> result = new ArrayList<>();

    findAllLeaves(result, 0, 0, N - 1);

    System.out.println(result);

    int sumArea = 0;
    for (final Interval interval : result) {
      sumArea += (interval.end - interval.start) * interval.height;
      // use put if absent to skip the 0 height intervals
      intervals.putIfAbsent(sumArea, interval);
    }

    System.out.println(intervals);

  }

  private Map<Integer, Integer> coordinateCompression(final int[][] rects) {
    final Set<Integer> criticalPoints = new HashSet<>();
    for (final int[] rect : rects) {
      final int startPoint = rect[0], endPoint = rect[1];
      criticalPoints.add(startPoint);
      criticalPoints.add(endPoint);
    }
    List<Integer> sorted = new ArrayList<>(criticalPoints);
    Collections.sort(sorted);
    final Map<Integer, Integer> result = new HashMap<>();
    int t = 0;
    for (final int coordinate : sorted) {
      result.put(coordinate, t++);
    }
    return result;
  }

  private void findAllLeaves(final List<Interval> result, final int si, final int ss, final int se) {
    if (ss > se) {
      return;
    }
    if (ss == se) {
      // use map to convert.
      result.add(new Interval(criticalPoints.get(ss), criticalPoints.get(se) + 1, segmentTrees[si]));
      return;
    }
    final int mid = ss + (se - ss) / 2;
    findAllLeaves(result, 2 * si + 1, ss, mid);
    findAllLeaves(result, 2 * si + 2, mid + 1, se);
  }

  /**
   * @param qs
   * @param qe  inclusive
   * @param val max value to compare
   */
  private void update(final int qs, final int qe, final int val) {
    update(0, 0, N - 1, qs, qe, val);
  }

  private void update(final int si, final int ss, final int se, final int qs, final int qe, final int
      val) {
    if (ss > se || ss > qe || se < qs) {
      return;
    }
    if (ss == se) {
      maxArea += val - segmentTrees[si];
    }
    /* fully covered */
    segmentTrees[si] = Math.max(segmentTrees[si], val);

    if (ss != se) {
      // no need to check ss != se
      final int mid = ss + (se - ss) / 2;
      update(2 * si + 1, ss, mid, qs, qe, val);
      update(2 * si + 2, mid + 1, se, qs, qe, val);
    }
  }

  public Point getPoint() {
    final int area = random.nextInt(maxArea);

    final Interval interval = intervals.higherEntry(area).getValue();

    final double x = random.nextDouble() * (interval.end - interval.start) + interval.start,
        y = random.nextDouble() * interval.height;
    return new Point(x, y);
  }

  private static final class Interval {

    private final int start, end, height;

    private Interval(int start, int end, int height) {
      this.start = start;
      this.end = end;
      this.height = height;
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

  static final class Point {
    final double x, y;

    private Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Point point = (Point) o;
      return Double.compare(point.x, x) == 0 &&
          Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {

      return Objects.hash(x, y);
    }

    @Override
    public String toString() {
      return "Point{" +
          "x=" + x +
          ", y=" + y +
          '}';
    }
  }


}
