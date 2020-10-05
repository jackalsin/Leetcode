package _0951_1000._955_Delete_Columns_to_Make_Sorted_II;

/**
 * @author zhixi
 * @version 1.0 on 9/29/2020
 */
public final class SolutionI implements Solution {
  /**
   * <a href='https://leetcode.com/problems/delete-columns-to-make-sorted-ii/discuss/203182/JavaC%2B%2BPython-Greedy-Solution-O(MN)'></a>
   */
  @Override
  public int minDeletionSize(String[] A) {
    final int rows = A.length, cols = A[0].length();
    final boolean[] isSorted = new boolean[rows - 1];
    int result = 0;
    for (int j = 0; j < cols; ++j) {
      int i = 0;
      for (; i < rows - 1; ++i) {
        if (!isSorted[i] && A[i].charAt(j) > A[i + 1].charAt(j)) {
          result++;
          break;
        }
      } // end of for i in row
      if (i < rows - 1) continue; // deleting the col;
      for (i = 0; i < rows - 1; ++i) {
        isSorted[i] |= A[i].charAt(j) < A[i + 1].charAt(j);
      }
    }
    return result;
  }
}
