package _0801_0850._805_Split_Array_With_Same_Average;

public final class SolutionII implements Solution {

  /**
   * Time Complexity: O(N^2 * sum)
   *
   * @param A
   * @return
   */
  public boolean splitArraySameAverage(int[] A) {
    int sum = 0;
    for (int a : A) {
      sum += a;
    }

    /*
     *sums[i][j] denotes if sum <tt>i</tt> can be achieved by using j numbers from the subarray A[0, i];
     */
    final boolean[][] sums = new boolean[sum + 1][A.length / 2 + 1];
    sums[0][0] = true;
    for (int num : A) { // num of A
      for (int i = sum; i >= num; i--) { // sum
        for (int j = 1; j <= A.length / 2; j++) {
          sums[i][j] = sums[i][j] || sums[i - num][j - 1];
        }
      }
    }

    for (int size = 1; size <= A.length / 2; size++) {
      if (sum * size % A.length == 0 && sums[sum * size / A.length][size]) {
        return true;
      }
    }

    return false;
  }

}
