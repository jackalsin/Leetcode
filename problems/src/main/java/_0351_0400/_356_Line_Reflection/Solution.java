package _0351_0400._356_Line_Reflection;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public class Solution {
  /**
   * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the
   * given points.
   * Example 1:
   * Given points = [[1,1],[-1,1]], return true.
   * Example 2:
   * Given points = [[1,1],[-1,-1]], return false.
   * Follow up:
   * Could you do better than O(n2)?
   * Credits:
   * Special thanks to @memoryless for adding this problem and creating all test cases.
   *
   * @param points
   * @return
   */
  public boolean isReflected(int[][] points) {
    Arrays.sort(points, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
          return Integer.compare(o1[0], o2[0]);
        } else {
          return Integer.compare(o1[1], o2[1]);
        }
      }
    });
    Long sum = null;
    int start = 0, end = 0;
    while (start < points.length) {
      end = start; //end: exclusive
      while (end < points.length && points[end][1] == points[start][1]) end++;
      int left = start, right = end - 1;
      while (left <= right) {
        long curSum = ((long) (points[left++][0]) + (long) (points[right--][0]));
        if (sum == null) {
          sum = curSum;
        } else if (!sum.equals(curSum)) {
          return false;
        }
        while (left <= end - 1 && points[left - 1][0] == points[left][0]) left++;
        while (start <= right && points[right + 1][0] == points[right][0]) right--;
      }
      start = end;
    }
    return true;
  }
}
