package airbnb._755_Pour_Water;

/**
 * @author jacka
 * @version 1.0 on 2/10/2019.
 */
public final class SolutionI implements Solution {

  /**
   * This question is similar to @see <a href="https://leetcode.com/problems/pour-water/">755. Pour Water</a>
   * However, we have different assumption:
   * 1. Both sides don't have boundary
   * 2. Assume, the drop will fall into the closest possible position, either left or right
   * 3. if neither side has a position for it, we discard it
   *
   * @param heights
   * @param V
   * @param K       position
   * @return
   */
  public int[] pourWater(int[] heights, int V, int K) {
    if (heights == null || heights.length == 0) {
      return heights;
    }
    for (int v = 0; v < V; v++) {
      final int bestPosLeft = getBestPosition(heights, K, -1), bestPosRight = getBestPosition(heights, K, 1);
      if (bestPosLeft == -1 && bestPosRight == -1) {
        return heights;
      } else if (bestPosLeft == -1) {
        heights[bestPosRight]++;
      } else if (bestPosRight == -1) {
        heights[bestPosLeft]++;
      } else {
        if (K - bestPosLeft <= bestPosRight - K) {
          heights[bestPosLeft]++;
        } else {
          heights[bestPosRight]++;
        }
      }
    }
    return heights;
  }

  /**
   * @param heights
   * @param pos
   * @param dir
   * @return
   */
  static int getBestPosition(final int[] heights, final int pos, final int dir) {
    int bestPos = pos, bestHeight = heights[bestPos];
    for (int i = pos + dir; i >= -1 || i <= heights.length; i += dir) {
      if (i == -1 || i == heights.length) {
        return -1;
      }
      if (heights[i] < bestHeight) {
        bestHeight = heights[i];
        bestPos = i;
      } else if (heights[i] == bestHeight) {
        continue;
      } else {
        break;
      }
    }
    return bestPos == pos ? -1 : bestPos;
  }

}
