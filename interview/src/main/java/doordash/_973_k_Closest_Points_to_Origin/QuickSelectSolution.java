package doordash._973_k_Closest_Points_to_Origin;

public final class QuickSelectSolution implements Solution {
  @Override
  public int[][] kClosest(int[][] points, int k) {
    if (points == null || k < 0) return new int[0][];
    final int index = quickSelect(points, 0, points.length - 1, k);
    final int[][] res = new int[k][];
    System.arraycopy(points, 0, res, 0, k);
    return res;
  }

  private int quickSelect(final int[][] points, final int left, final int right, final int k) {
    assert left <= right;
    if (left == right) {
      return left;
    }
    final int pivot = right, pivotVal = getVal(points[right]);
    int p = left;
    for (int i = left; i < right; ++i) {
      final int val = getVal(points[i]);
      if (val < pivotVal) {
        swap(points, i, p);
        p++;
      }
    }
    swap(points, p, right);
    final int curPLen = p - left + 1;
    if (curPLen < k) {
      return quickSelect(points, p + 1, right, k - curPLen);
    } else if (p - left + 1 == k) {
      return left;
    } else {
      return quickSelect(points, left, p - 1, k);
    }
  }

  private static void swap(final int[][] points, final int i, final int j) {
    final int[] tmp = points[i];
    points[i] = points[j];
    points[j] = tmp;
  }

  private static int getVal(final int[] p) {
    return p[0] * p[0] + p[1] * p[1];
  }
}
