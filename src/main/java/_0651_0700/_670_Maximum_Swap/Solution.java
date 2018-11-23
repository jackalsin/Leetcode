package _0651_0700._670_Maximum_Swap;

public class Solution {
  /**
   * 111 / 111 test cases passed.
   * Status: Accepted
   * Runtime: 5 ms
   *
   * @param num
   * @return
   */
  public int maximumSwap(final int num) {
    assert num >= 0;
    final char[] chars = String.valueOf(num).toCharArray();
    int[] digitToPos = new int[10];
    for (int i = 0; i < chars.length; i++) {
      digitToPos[chars[i] - '0'] = i;
    }

    for (int i = 0; i < chars.length; i++) {
      final int digit = chars[i] - '0';
      for (int k = 9; k > digit; k--) {
        if (digitToPos[k] > i) {
          char tmp = chars[digitToPos[k]];
          chars[digitToPos[k]] = chars[i];
          chars[i] = tmp;

          return Integer.valueOf(String.valueOf(chars));
        }
      }
    }

    return num;
  }

}
