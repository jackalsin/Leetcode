package uber._699_Falling_Squares;

import java.util.*;

public final class SegmentTreeSolution implements Solution {
  private int[] st;
  private int N;

  @Override
  public List<Integer> fallingSquares(int[][] positions) {
    final Map<Integer, Integer> criticalPoints = getCriticalPoints(positions);
    N = criticalPoints.size();

    final List<Integer> result = new ArrayList<>();
    final int h = (int) Math.ceil((Math.log(N) / Math.log(2)));
    st = new int[2 * ((int) Math.pow(2, h)) + 1];
    int curMax = 0;
    for (final int[] pos : positions) {
      final int left = criticalPoints.get(pos[0]),
          right = criticalPoints.get(pos[0] + pos[1] - 1),
          hi = pos[1];
      int curMaxInRange = query(st, left, right);
      curMax = Math.max(curMaxInRange + hi, curMax);
      update(st, left, right, curMaxInRange + hi);
      result.add(curMax);
    }
    return result;
  }

  private void update(int[] st, int qs, int qe, int val) {
    update(st, 0, 0, N - 1, qs, qe, val);
  }

  private void update(int[] st, int si, int ss, int se, int qs, int qe, int val) {
    if (se < qs || qe < ss || se < ss) {
      return;
    }

    st[si] = Math.max(st[si], val);
    if (ss != se) {
      final int mid = (se - ss) / 2 + ss;
      update(st, si * 2 + 1, ss, mid, qs, qe, val);
      update(st, si * 2 + 2, mid + 1, se, qs, qe, val);
    }
  }

  private int query(int[] st, int qs, int qe) {
    return query(st, 0, 0, N - 1, qs, qe);
  }

  private int query(int[] st, int si, int ss, int se, int qs, int qe) {
    if (se < qs || qe < ss || ss > se) {
      return 0;
    }

    if (qs <= ss && se <= qe) {
      return st[si];
    }

    final int mid = (se - ss) / 2 + ss;

    return Math.max(
        query(st, si * 2 + 1, ss, mid, qs, qe), query(st, si * 2 + 2, mid + 1, se, qs, qe));
  }

  private Map<Integer, Integer> getCriticalPoints(int[][] positions) {
    final Set<Integer> cp = new HashSet<>();
    for (final int[] pos : positions) {
      cp.add(pos[0]);
      cp.add(pos[0] + pos[1] - 1);
    }
    final List<Integer> cpList = new ArrayList<>(cp);
    Collections.sort(cpList);

    final Map<Integer, Integer> result = new HashMap<>();
    for (int i = 0; i < cpList.size(); i++) {
      result.put(cpList.get(i), i);
    }
    return result;
  }
}
