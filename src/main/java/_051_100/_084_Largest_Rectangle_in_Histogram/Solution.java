package _051_100._084_Largest_Rectangle_in_Histogram;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/20/2017.
 */
public class Solution {
  /*
  * Solution:
  */

  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }
    Deque<Integer> rectStack = new ArrayDeque<>();
    int maxArea = 0;
    for(int i = 0; i <= heights.length; i++) {
      int h = i == heights.length ? 0: heights[i];
      if (rectStack.isEmpty() || heights[rectStack.peekLast()] <= h) {
        rectStack.addLast(i);
      } else { // Calculate area of rectangle with hist[tp] as smallest bar.
        int tp = rectStack.removeLast();
        maxArea = Math.max(maxArea, heights[tp] * (rectStack.isEmpty() ? i : i - 1 - rectStack
            .peekLast()));
        i--;
      }
    }
    return maxArea;
  }
}
