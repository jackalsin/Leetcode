package _351_400._358_Rearrange_String_k_Distance_Apart;

/**
 * @author jacka
 * @version 1.0 on 10/12/2017.
 */
public class Solution {
  /**
   *
   * @param s
   * @param k
   * @return
   */
  public String rearrangeString(String s, int k) {
    final char[] counts = new char[26];
    /* The left most valid position for a certain character. */
    final int[] valid = new int[26];
    for (char ch : s.toCharArray()) {
      counts[ch - 'a']++;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); ++i) {
      int candidatePos = findMaxValid(counts, valid, i);
      if (candidatePos == -1) {
        return "";
      }
      counts[candidatePos]--;
      valid[candidatePos] = i + k;
      sb.append((char) ('a' + candidatePos));
    }
    return sb.toString();
  }

  /**
   * Return -1 when cannot find valid position for index <tt>i</tt>.
   */
  int findMaxValid(final char[] counts, final int[] valid, int i) {
    int max = 0, candidatePos = -1;
    for (int k = 0; k < counts.length; ++k) {
      if (counts[k] > max && i >= valid[k]) {
        max = counts[k];
        candidatePos = k;
      }
    }
    return candidatePos;
  }

}
