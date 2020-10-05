package _0451_0500._484_Find_Permutation;

public class EasyUnderstandSolution implements Solution {
  private static final char D = 'D';
  private static final char I = 'I';

  /**
   * https://discuss.leetcode.com/topic/76221/java-o-n-clean-solution-easy-to-understand
   *
   * @param s
   * @return
   */
  @Override
  public int[] findPermutation(String s) {
    final int[] res = new int[s.length() + 1];
    // fill the array with sorted elements
    for (int i = 0; i < res.length; i++) {
      res[i] = i + 1;
    }

    final char[] sArray = s.toCharArray();
    for (int i = 0; i < sArray.length; i++) {
      if (sArray[i] == D) {
        int start = i;
        while (i < s.length() && sArray[i] == D) i++;
        reverse(res, start, i);
      }
    }
    return res;
  }

  private void reverse(final int[] res, int start, int end) {
    while (start < end) {
      res[start] ^= res[end];
      res[end] ^= res[start];
      res[start] ^= res[end];
      start++;
      end--;
    }
  }
}
