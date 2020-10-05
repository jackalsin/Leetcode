package _0801_0850._850_Rectangle_Area_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 9/7/2020
 */
public final class SegmentTreeSolution implements Solution {
  /*这题贼有意思，如果硬来，用2d segment tree，time complexity 不如这个，这个是严格 N log N*/
  private static final int MOD = (int) (1E9 + 7);

  public int rectangleArea(int[][] rectangles) {
    final int n = rectangles.length;
    final TreeMap<Integer, List<Edge>> xToEdges = new TreeMap<>();
    final Set<Integer> criticalY = new HashSet<>();
    for (int i = 0; i < n; ++i) {
      final int[] r = rectangles[i];
      final int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
      criticalY.add(y1);
      criticalY.add(y2);
      xToEdges.computeIfAbsent(x1, k -> new ArrayList<>()).add(new Edge(y1, y2, 1));
      xToEdges.computeIfAbsent(x2, k -> new ArrayList<>()).add(new Edge(y1, y2, -1));
    }
    final List<Integer> sortedY = new ArrayList<>(criticalY);
    Collections.sort(sortedY);
    final Map<Integer, Integer> yToIndex = new HashMap<>();
    for (int i = 0; i < sortedY.size(); ++i) {
      yToIndex.put(sortedY.get(i), i);
    }
    final Node root = buildTrees(sortedY, 0, sortedY.size() - 1);
    int prevX = -1, sum = 0;
    for (final var e : xToEdges.entrySet()) {
      final int x = e.getKey();
      if (prevX != -1) {
        assert root != null;
        final long actualY = root.actual;
        sum = safeAdd(actualY * (x - prevX), sum);
      }
      final List<Edge> edges = e.getValue();
      for (final Edge edge : edges) {
        update(root, yToIndex.get(edge.y1), yToIndex.get(edge.y2), edge.val);
      }
      prevX = x;
//      System.out.println("x = " + x + ", sum = " + sum);
    }
//    System.out.println(root);
    return sum;
  }

  private long update(final Node root, final int qs, final int qe, final int countChange) {
    if (root == null || root.end <= qs || root.start >= qe) {
      return 0L;
    }
    if (root.start + 1 == root.end) {
      final long prevCount = root.count;
      root.count += countChange;
      if (prevCount == 0 && root.count > 0) {
        root.actual = root.capacity;
        return root.actual;
      }
      if (prevCount == 1 && root.count == 0) {
        root.actual = 0;
        return -root.capacity;
      }
      return 0;
    }
    final long prevActual = root.actual;
    root.actual = safeAdd(root.actual, update(root.left, qs, qe, countChange)
        + update(root.right, qs, qe, countChange));
    return root.actual - prevActual;
  }

  /**
   * @param start inclusive
   * @param end   inclusive
   */
  private static Node buildTrees(final List<Integer> vals, final int start, final int end) {
    if (start >= end) {
      return null;
    }
    if (start + 1 == end) {
      return new Node(start, end, vals.get(end) - vals.get(start), null, null);
    }
    final int mid = start + (end - start) / 2;
    final Node left = buildTrees(vals, start, mid),
        right = buildTrees(vals, mid, end);
    final long capacity = (left == null ? 0L : left.capacity) +
        (right == null ? 0L : right.capacity);
    return new Node(start, end, capacity, left, right);
  }

  private static int safeAdd(long a, final long b) {
    return (int) ((a + b) % MOD + MOD) % MOD;
  }

  private static final class Node {

    /**
     * capacity should only be used on leaf node
     */
    private final int start, end;
    private final long capacity;
    private long actual = 0, count = 0;
    private final Node left, right;

    private Node(int start, int end, long capacity, final Node left, final Node right) {
      this.start = start;
      this.end = end;
      this.capacity = capacity;
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return "Node{" +
          "start=" + start +
          ", end=" + end +
          ", capacity=" + capacity +
          ", actual=" + actual +
          ", count=" + count +
          ", left=" + left +
          ", right=" + right +
          '}';
    }
  }

  private static final class Edge {
    private final int y1, y2, val;

    private Edge(int y1, int y2, int val) {
      assert y1 <= y2;
      this.y1 = y1;
      this.y2 = y2;
      this.val = val;
    }

    @Override
    public String toString() {
      return "Edge{" +
          "y1=" + y1 +
          ", y2=" + y2 +
          ", val=" + val +
          '}';
    }
  }
}
