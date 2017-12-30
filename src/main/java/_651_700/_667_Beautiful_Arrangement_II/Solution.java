package _651_700._667_Beautiful_Arrangement_II;

/**
 * 1, k+1, 2, k, 3, k-1 ...;
 * The distance of this sequence is k, k-1, k-2, ..., 2, 1
 * https://discuss.leetcode.com/topic/101135/c-concise-code-o-n
 */
public class Solution {

  public int[] constructArray(int n, int k) {
    final int[] result = new int[n];
    int left = 1, right = k + 1, i = 0;
    // 取这个等于号是因为left和right均未被添加到result array当中
    while (left <= right) {
      result[i++] = left++;
      if (left < right) {
        result[i++] = right--;
      }
    }

    for (int j = k + 2; j <= n; j++) {
      result[i++] = j;
    }
    return result;
  }

}
