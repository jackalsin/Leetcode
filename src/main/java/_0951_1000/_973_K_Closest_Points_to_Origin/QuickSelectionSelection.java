package _0951_1000._973_K_Closest_Points_to_Origin;

/**
 * @author jacka
 * @version 1.0 on 5/30/2020
 */
public final class QuickSelectionSelection implements Solution {
  @Override
  public int[][] kClosest(int[][] points, int K) {
    if (points == null || points.length == 0) {
      return new int[][]{};
    }
    /*Time Complexity: O(N)*/
    final int N = points.length;
    int left = 0, right = N - 1;
    final int pivotIndex = getPartition(points, K, left, right);
    final int[][] result = new int[K][2];
    System.arraycopy(points, 0, result, 0, K);
    return result;
  }

  private int getPartition(final int[][] points, final int K, final int start, final int end) {
//    System.out.println("K = " + K + ", start = " + start + ", end = " + end);
    assert start <= end;
    if (start == end) return start;
    final int pVal = distance(points[end]);
    int p = start;
    for (int i = start; i < end; ++i) {
      if (distance(points[i]) <= pVal) {
        swap(points, p, i);
        p++;
      }
    }
    swap(points, p, end);
    final int curPLen = p - start + 1;
    if (curPLen == K) {
      return curPLen;
    } else if (curPLen < K) {
      return getPartition(points, K - curPLen, p + 1, end);
    } else {
      return getPartition(points, K, start, p - 1);
    }
  }

  private static void swap(final int[][] points, final int i, final int j) {
    final int[] tmp = points[i];
    points[i] = points[j];
    points[j] = tmp;
  }

  private static int distance(final int[] p) {
    return p[0] * p[0] + p[1] * p[1];
  }

}
