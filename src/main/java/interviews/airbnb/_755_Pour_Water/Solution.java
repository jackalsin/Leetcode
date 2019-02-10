package interviews.airbnb._755_Pour_Water;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public class Solution {

  public int[] pourWater(int[] heights, int V, int K) {
    final int leftStart = K - 1, rightStart = K + 1;
    for (int i = 0; i < V; i++) {
      if (moveLeftIfPossible(heights, leftStart) || moveRightIfPossible(heights, rightStart)) {
        continue;
      }
      heights[K]++;
    }
    return heights;
  }

  private static boolean moveLeftIfPossible(final int[] heights, final int leftStart) {
    int best = leftStart + 1;
    for (int i = leftStart; i >= 0; i--) {
      if (heights[i] < heights[best]) {
        best = i;
      } else if (heights[i] > heights[best]) {
        break;
      }
    }
    if (best != leftStart + 1) {
      heights[best]++;
      return true;
    }
    return false;
  }

  private static boolean moveRightIfPossible(final int[] heights, final int rightStart) {
    int best = rightStart - 1;
    for (int i = rightStart; i < heights.length; i++) {
      if (heights[i] < heights[best]) {
        best = i;
      } else if (heights[i] > heights[best]) {
        break;
      }
    }
    if (best != rightStart - 1) {
      heights[best]++;
      return true;
    }
    return false;
  }
}
