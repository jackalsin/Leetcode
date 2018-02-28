package _651_700._699_Falling_Squares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SegmentTreeLazyPropagationSolution implements Solution {

  /**
   * 44 / 44 test cases passed.
   * Status: Accepted
   * Runtime: 51 ms
   * Submitted: 1 minute ago
   *
   * @param positions
   * @return
   */
  @Override
  public List<Integer> fallingSquares(int[][] positions) {
    final Map<Integer, Integer> sortedCoords = coordinateCompression(positions);
    SegmentTree tree = new SegmentTree(sortedCoords.size());
    int best = 0;
    final List<Integer> result = new ArrayList<>();

    for (int[] pos : positions) {
      int L = sortedCoords.get(pos[0]);
      int R = sortedCoords.get(pos[0] + pos[1] - 1);
      int h = tree.query(L, R) + pos[1];
      tree.update(L, R, h);
      best = Math.max(best, h);
      result.add(best);
    }
    return result;
  }

  private static Map<Integer, Integer> coordinateCompression(int[][] positions) {
    final Set<Integer> points = new HashSet<>();
    for (final int[] pos : positions) {
      points.add(pos[0]);
      points.add(pos[0] + pos[1] - 1);
    }

    final List<Integer> sorted = new ArrayList<>(points);
    Collections.sort(sorted);
    final Map<Integer, Integer> result = new HashMap<>();
    int t = 0;
    for (final int i : sorted) result.put(i, t++);
    return result;
  }

  private static final class SegmentTree {
    private final int[] tree, lazy;
    private final int N;

    SegmentTree(final int N) {
      this.N = N;
      final int h = (int) Math.ceil(Math.log(N) / Math.log(2));
      final int size = 2 * (int) Math.pow(2, h) + 1;
      tree = new int[size];
      lazy = new int[size];
    }

    void update(final int qs, final int qe, final int val) {
      update(0, 0, N - 1, qs, qe, val);
    }

    void update(final int si, final int ss, final int se, final int qs, final int qe, final int val) {

      if (lazy[si] != 0) {
        tree[si] = Math.max(tree[si], lazy[si]);

        // propagate to the child
        if (ss != se) {
          lazy[si * 2 + 1] = Math.max(lazy[si * 2 + 1], val);
          lazy[si * 2 + 2] = Math.max(lazy[si * 2 + 2], val);
        }

        lazy[si] = 0;
      }


      if (ss > se || se < qs || ss > qe) {
        return;
      }

      if (qs <= ss && se <= qe) {
        tree[si] = Math.max(val, tree[si]);

        // store the update value to lazy[], rather than update them to the child segment
        if (ss != se) {
          lazy[2 * si + 1] = Math.max(lazy[2 * si + 1], val);
          lazy[2 * si + 2] = Math.max(lazy[2 * si + 2], val);
        }
        return;
      }
      if (ss != se) {
        final int mid = ss + (se - ss) / 2;
        update(si * 2 + 1, ss, mid, qs, qe, val);
        update(si * 2 + 2, mid + 1, se, qs, qe, val);
        tree[si] = Math.max(tree[2 * si + 1], tree[2 * si + 2]);
      }

    }

    int query(final int qs, final int qe) {
      return query(0, 0, N - 1, qs, qe);
    }

    int query(final int si, final int ss, final int se, final int qs, final int qe) {
      if (lazy[si] != 0) {
        tree[si] = Math.max(lazy[si], tree[si]);
        if (ss != se) {
          lazy[2 * si + 1] = Math.max(lazy[2 * si + 1], lazy[si]);
          lazy[2 * si + 2] = Math.max(lazy[2 * si + 2], lazy[si]);
        }
        lazy[si] = 0;
      }

      if (ss > se || se < qs || ss > qe) {
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
