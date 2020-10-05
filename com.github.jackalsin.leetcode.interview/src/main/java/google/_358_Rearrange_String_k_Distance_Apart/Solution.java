package google._358_Rearrange_String_k_Distance_Apart;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
public class Solution {
  private static final int N = 26;

  /**
   * http://www.1point3acres.com/bbs/thread-324935-1-1.html
   * 57 / 57 test cases passed.
   * Status: Accepted
   * Runtime: 17 ms
   */
  public String rearrangeString(String s, int k) {
    /* Valid[i]指的是最早能出现的位置 */
    final int[] counts = new int[N], valid = new int[N];
    final char[] sChars = s.toCharArray();
    for (final char chr : sChars) {
      counts[chr - 'a']++;
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < sChars.length; i++) {
      int candidateIndex = findMaxValid(counts, valid, i);
      if (candidateIndex == -1) {
        return "";
      }
      valid[candidateIndex] = i + k;
      counts[candidateIndex]--;
      sb.append((char) ('a' + candidateIndex));
    }
    return sb.toString();
  }

  private int findMaxValid(int[] counts, int[] valid, int index) {
    int candidateIndex = -1, maxCount = 0;
    for (int i = 0; i < counts.length; i++) {
      if (counts[i] > maxCount && index >= valid[i]) {
        candidateIndex = i;
        maxCount = counts[i];
      }
    }
    return candidateIndex;
  }
}
