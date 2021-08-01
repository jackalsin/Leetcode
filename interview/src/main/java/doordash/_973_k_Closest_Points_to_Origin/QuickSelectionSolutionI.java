package doordash._973_k_Closest_Points_to_Origin;

import java.util.Random;

public final class QuickSelectionSolutionI implements Solution {
  private final Random rand = new Random();

  public int[][] kClosest(int[][] points, int k) {
    if (points == null) return points;
    final int n = points.length;
    final Pair[] pairs = new Pair[n];
    for (int i = 0; i < n; ++i) {
      pairs[i] = new Pair(i, getDistance(points[i]));
    }
    quickSelect(pairs, 0, n - 1, k);
    final int[][] res = new int[k][];
    for (int i = 0; i < k; ++i) {
      res[i] = points[pairs[i].index];
    }
    return res;
  }

  private void quickSelect(final Pair[] pairs, final int left, final int right, final int k) {
    if (left >= right) return;
    final int pivotIndex = rand.nextInt(right - left) + left;
    final long pVal = pairs[pivotIndex].distance;
    swap(pairs, pivotIndex, right);
    int p = left;
    for (int i = left; i < right; ++i) {
      if (pairs[i].distance < pVal) {
        swap(pairs, i, p);
        p++;
      }
    }
    swap(pairs, p, right);
    final int leftLen = p - left + 1;
    if (leftLen == k) {
      return;
    } else if (leftLen < k) {
      quickSelect(pairs, p + 1, right, k - leftLen);
    } else {
      quickSelect(pairs, left, p - 1, k);
    }
  }

  private static void swap(final Pair[] pairs, final int i, final int j) {
    final Pair tmp = pairs[i];
    pairs[i] = pairs[j];
    pairs[j] = tmp;
  }

  private static long getDistance(final int[] p) {
    final long x = p[0], y = p[1];
    return x * x + y * y;
  }

  private static final class Pair {
    private final int index;
    private final long distance;

    private Pair(int index, long distance) {
      this.index = index;
      this.distance = distance;
    }
  }
}
