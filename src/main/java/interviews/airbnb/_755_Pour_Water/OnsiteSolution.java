package interviews.airbnb._755_Pour_Water;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
public final class OnsiteSolution {
  /**
   * @param heights
   * @param V
   * @param K       position
   * @return
   */
  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null) {
      throw new NullPointerException();
    }
    if (V < 0 || K < 0) {
      throw new IllegalArgumentException();
    }
    final int[] result = new int[heights.length];
    System.arraycopy(heights, 0, result, 0, heights.length);

    for (int i = 0; i < V; i++) {
      if (!moveLeftIfPossible(result, K) && !moveRightIfPossible(result, K)) {
        result[K]++;
      }
    }
    display(result, heights);
    return result;
  }

  private static void display(final int[] result, final int[] base) {
    final int max = Arrays.stream(result).max().orElse(0);
    for (int m = max; m > 0; m--) {
      for (int i = 0; i < result.length; i++) {
        if (result[i] < m) {
          System.out.print(' ');
        } else {
          System.out.print(m > base[i] ? 'w' : '+');
        }
      }
      System.out.println();
    }
  }

  private boolean moveRightIfPossible(final int[] result, final int k) {
    int curHeight = result[k], curHeightIndex = k;
    for (int i = k + 1; i < result.length; i++) {
      if (result[i] < curHeight) {
        curHeightIndex = i;
        curHeight = result[i];
      } else if (result[i] > curHeight) {
        break;
      }
    }
    if (curHeightIndex != k) {
      result[curHeightIndex]++;
      return true;
    }
    return false;
  }

  private boolean moveLeftIfPossible(final int[] result, final int k) {
    int best = k;
    for (int i = k - 1; i >= 0; i--) {
      if (result[i] < result[best]) {
        best = i;
      } else if (result[i] > result[best]) {
        break;
      }
    }
    if (best != k) {
      result[best]++;
      return true;
    }
    return false;
  }

}
