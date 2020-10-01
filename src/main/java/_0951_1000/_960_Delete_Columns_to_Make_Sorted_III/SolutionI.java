package _0951_1000._960_Delete_Columns_to_Make_Sorted_III;

/**
 * @author jacka
 * @version 1.0 on 9/30/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int minDeletionSize(String[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int len = A[0].length();
    if (len == 0) {
      return 0;
    }
    /* max cols that can be kept */
    final int[] dp = new int[len + 1];
    dp[1] = 1;
    for (int i = 1; i < len; i++) {
      dp[i + 1] = 1;
      for (int j = 0; j < i; ++j) {
        if (isSorted(A, j, i)) {
          dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);
        }
      }
    }
//    System.out.println(Arrays.toString(dp));
    int min = len;
    for (int i = 0; i <= len; ++i) {
      min = Math.min(min, len - dp[i]);
    }
    return min;
  }

  private static boolean isSorted(final String[] strs, final int i, final int j) {
    for (final String str : strs) {
      if (str.charAt(i) > str.charAt(j)) return false;
    }
    return true;
  }
}
