package airbnb._755_Pour_Water;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public final class LeetcodeSolution implements Solution {

  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null || V < 0 || K < 0 || K >= heights.length) {
      throw new IllegalArgumentException();
    }
    final int[] result = new int[heights.length];
    System.arraycopy(heights, 0, result, 0, heights.length);
    for (int v = 0; v < V; v++) {
      if (!moveLeftIfPossible(result, K) && !moveRightIfPossible(result, K)) {
        result[K]++;
      }
    }
    return result;
  }

  private static boolean moveRightIfPossible(final int[] result, final int k) {
    int min = result[k], minIndex = k;
    for (int i = k + 1; i < result.length; i++) {
      if (result[i] > min) {
        break;
      } else if (result[i] < min) {
        min = result[i];
        minIndex = i;
      }
    }
    if (minIndex != k) result[minIndex]++;
    return minIndex != k;
  }

  private static boolean moveLeftIfPossible(final int[] result, final int k) {
    int min = result[k], minIndex = k;
    for (int i = k - 1; i >= 0; i--) {
      if (result[i] > min) {
        break;
      } else if (result[i] < min) {
        min = result[i];
        minIndex = i;
      }
    }
    if (minIndex != k) result[minIndex]++;
    return minIndex != k;
  }
}
