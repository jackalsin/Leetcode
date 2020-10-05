package google._521_Longest_Uncommon_Subsequence_I;

/**
 * @author jacka
 * @version 1.0 on 1/17/2018.
 */
public class Solution {
  private static final char A = 'a';

  public int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
}
