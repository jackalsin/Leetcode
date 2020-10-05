package _0751_0800._755_Pour_Water;

public class Solution {
  private int leftStart;
  private int rightStart;

  /**
   * Time Complexity: O(V * N)
   *
   * @param heights
   * @param V
   * @param K
   * @return
   */
  public int[] pourWater(int[] heights, int V, int K) {
    //heights will have length in [1, 100] and contain integers in [0, 99].
    //V will be in range [0, 2000].
    //K will be in range [0, heights.length - 1].
    leftStart = K - 1;
    rightStart = K + 1;

    for (int v = 0; v < V; v++) {
      if (moveLeftIfValid(heights) || moveRightIfValid(heights)) {
        continue;
      }
//      System.out.println(K);
      heights[K]++;
    }
    return heights;
  }

  private boolean moveLeftIfValid(final int[] heights) {
    int minHeight = heights[leftStart + 1], minIndex = leftStart + 1;

    for (int left = leftStart; left >= 0; left--) {
      final int curHeight = heights[left];
      if (curHeight <= minHeight) {
        if (curHeight < minHeight) {
          minIndex = left;
        }
        minHeight = curHeight;
      } else {
        break;
      }
    } // end of for loop

    if (minIndex != leftStart + 1) {
//      System.out.println(minIndex);
      heights[minIndex]++;
      return true;
    }
    return false;
  }

  private boolean moveRightIfValid(final int[] heights) {
    int minHeight = heights[rightStart - 1], minIndex = rightStart - 1;

    for (int right = rightStart; right < heights.length; right++) {
      final int curHeight = heights[right];
      if (curHeight <= minHeight) {
        if (curHeight < minHeight) {
          minIndex = right;
        }
        minHeight = curHeight;
      } else {
        break;
      }
    } // end of for loop

    if (minIndex != rightStart - 1) {
//      System.out.println(minIndex);
      heights[minIndex]++;
      return true;
    }
    return false;
  }
}
