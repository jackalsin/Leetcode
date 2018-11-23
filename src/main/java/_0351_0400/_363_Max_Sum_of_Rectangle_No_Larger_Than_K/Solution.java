package _0351_0400._363_Max_Sum_of_Rectangle_No_Larger_Than_K;

import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class Solution {

  public int maxSumSubmatrix(int[][] matrix, int k) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
    final int rows = matrix.length, cols = matrix[0].length;
    int curMax = Integer.MIN_VALUE;
    for (int leftCol = 0; leftCol < cols; leftCol++) {
      final int[] sums = new int[rows];
      for (int rightCol = leftCol; rightCol < cols; rightCol++) {
        for (int row = 0; row < rows; row++) {
          sums[row] += matrix[row][rightCol];
        }

        TreeSet<Integer> prevSumSet = new TreeSet<>();
        prevSumSet.add(0);
        int curSum = 0;
        for (int sum : sums) {
          curSum += sum;
          Integer gap = prevSumSet.ceiling(curSum - k);
          if (gap != null) {
            curMax = Math.max(curMax, curSum - gap);
          }
          prevSumSet.add(curSum);
        }
      }
    }
    return curMax;
  }

  public static void main(String[] args) {
    final int[] nums = new int[] {1, 2, 3, -5, 4};
    final int k = 4;
    /*
    To solve this, scan from left to right. Put the cum[i]cum[i] values that you have encountered
    till now into a set. When you are processing cum[j]cum[j] what you need to retrieve from the set
    is the smallest number in the set such which is bigger than cum[j]−kcum[j]−k. This lookup can be
    done in O(logn)O(log⁡n) using upper_bound. Hence the overall complexity is O(nlog(n))O(nlog(n)).
    */
    TreeSet<Integer> prevSumSet = new TreeSet<>();
    prevSumSet.add(0);
    int curSum = 0, curMax = Integer.MIN_VALUE;
    for (int num : nums) {
      curSum += num;
      Integer remain = prevSumSet.ceiling(curSum - k);
      if (remain != null) {
        curMax = Math.max(curMax, curSum - remain);
      }
      prevSumSet.add(curSum);
    }
  }
}
