package _0651_0700._699_Falling_Squares;

import java.util.*;

/**
 * Time Complexity: O(NLogN)
 * 44 / 44 test cases passed.
 * Status: Accepted
 * Runtime: 53 ms
 */
public final class SegmentTreeSolution implements Solution {

  public List<Integer> fallingSquares(int[][] positions) {
    final Map<Integer, Integer> sortedCoords = coordinateCompression(positions);
    SegmentTree tree = new SegmentTree(sortedCoords.size());
    int best = 0;
    List<Integer> ans = new ArrayList<>();

    for (int[] pos : positions) {
      int L = sortedCoords.get(pos[0]);
      int R = sortedCoords.get(pos[0] + pos[1] - 1);
      int h = tree.query(L, R) + pos[1];
      tree.update(L, R, h);
      best = Math.max(best, h);
      ans.add(best);
    }
    return ans;
  }

  /**
   * @param positions
   * @return
   */
  private Map<Integer, Integer> coordinateCompression(final int[][] positions) {
    /*
     * 取出关键点，那么不需要initialize很大的数组，只需要按照t来initialize了
     */
    final Set<Integer> sets = new HashSet<>();
    for (final int[] pos : positions) {
      sets.add(pos[0]);
      sets.add(pos[0] + pos[1] - 1);
    }
    List<Integer> sorted = new ArrayList<>(sets);
    Collections.sort(sorted);
    final Map<Integer, Integer> result = new HashMap<>();
    int t = 0;
    for (final int coordinate : sorted) {
      result.put(coordinate, t++);
    }
    return result;
  }

  private static final class SegmentTree {
    private final int[] tree;
    private final int N;

    SegmentTree(final int N) {
      this.N = N;
      final int h = (int) Math.ceil(Math.log(N) / Math.log(2));
      final int size = 2 * (int) Math.pow(2, h) + 1;
      tree = new int[size];
    }

    public void update(final int qs, final int qe, final int val) {
      update(0, 0, N - 1, qs, qe, val);
    }

    private void update(final int si, final int ss, final int se, final int qs, final int qe, final int val) {
      if (ss > se || ss > qe || se < qs) {
        return;
      }

      final int mid = (se - ss) / 2 + ss;
      tree[si] = Math.max(tree[si], val);
      if (se != ss) {
        update(2 * si + 1, ss, mid, qs, qe, val);
        update(2 * si + 2, mid + 1, se, qs, qe, val);
      }

    }

    public int query(final int qs, final int qe) {
      return query(0, 0, N - 1, qs, qe);
    }

    private int query(final int si, final int ss, final int se, final int qs, final int qe) {
      if (ss > se || ss > qe || se < qs) {
        return 0;
      }

      if (qs <= ss && se <= qe) {
        return tree[si];
      }
      final int mid = (se - ss) / 2 + ss;
      return Math.max(query(2 * si + 1, ss, mid, qs, qe), query(2 * si + 2, mid + 1, se, qs, qe));
    }
  }
}
