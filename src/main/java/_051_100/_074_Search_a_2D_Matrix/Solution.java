package _051_100._074_Search_a_2D_Matrix;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 5/4/2017.
 */
public class Solution {

  public boolean searchMatrix(int[][] matrix, int target) {
    int rows = matrix.length;
    if (rows == 0) return false;
    int cols = matrix[0].length;
    if (cols == 0) return false;
    int startRow = 0, endRow = rows;
    if (target < matrix[0][0] && target > matrix[rows - 1][cols - 1]) {
      return false;
    }
    while (startRow <= endRow) {
      int midRow = (endRow - startRow) / 2 + startRow;
      if (matrix[midRow][0] == target) {
        return true;
      } else if (matrix[midRow][0] < target) {
        startRow = midRow;
      } else {
        endRow = midRow;
      }
      if (endRow - startRow <= 1) { // hit
        break;
      }
    }
    return searchCol(matrix[startRow], target);
  }

  boolean searchCol(int[] elems, int target) {
    int left = 0, right = elems.length - 1;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      if (target == elems[mid]) {
        return true;
      } else if (elems[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }
}
