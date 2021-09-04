package airbnb._755_Pour_Water;

/**
 * @author jacka
 * @version 1.0 on 9/4/2021
 */
public final class LeetcodeSolutionI implements LeetcodeSolution {
  @Override
  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null || heights.length == 0) return heights;
    final int len = heights.length;
    final int[] res = new int[len];
    System.arraycopy(heights, 0, res, 0, len);
    for (int v = 0; v < V; ++v) {
      if (!moveLeftIfPossible(res, K) && !moveRightIfPossible(res, K)) {
        res[K]++;
      }
    }
    return res;
  }

  private boolean moveRightIfPossible(final int[] res, final int k) {
    int min = res[k], minIndex = k;
    for (int i = k + 1; i < res.length; ++i) {
      if (res[i] > min) {
        break;
      } else {
        if (min > res[i]) {
          min = res[i];
          minIndex = i;
        }
      }
    }
    if (minIndex != k) res[minIndex]++;
    return minIndex != k;
  }

  private boolean moveLeftIfPossible(final int[] res, final int k) {
    int min = res[k], minIndex = k;
    for (int i = k - 1; i >= 0; --i) {
      if (res[i] > min) {
        break;
      } else {
        if (min > res[i]) {
          min = res[i];
          minIndex = i;
        }
      }
    }
    if (minIndex != k) res[minIndex]++;
    return minIndex != k;
  }
}
