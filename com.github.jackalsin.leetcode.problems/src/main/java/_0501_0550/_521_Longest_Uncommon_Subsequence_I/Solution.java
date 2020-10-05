package _0501_0550._521_Longest_Uncommon_Subsequence_I;

public class Solution {
  public int findLUSlength(String a, String b) {
    return a.equals(b) ? -1 : Math.max(a.length(), b.length());
  }
}
