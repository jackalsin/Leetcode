package _0551_0600._567_Permutation_in_String;

/**
 * 102 / 102 test cases passed. Status: Accepted Runtime: 17 ms
 *
 * @author Zhiwei.Xin
 * @version 1.0 on 10/30/2017.
 */
public final class CompareOcurrenceSolution implements Solution {
  @Override
  public boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }
    final int[] counts = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      counts[s1.charAt(i) - 'a']++;
      counts[s2.charAt(i) - 'a']--;
    }
    if (allZero(counts)) {
      return true;
    }
    final char[] s2Chars = s2.toCharArray();
    for (int i = s1.length(); i < s2Chars.length; i++) {
      counts[s2Chars[i] - 'a']--;
      counts[s2Chars[i - s1.length()] - 'a']++;
      if (allZero(counts)) {
        return true;
      }
    }
    return false;
  }

  private static boolean allZero(final int[] counts) {
    for (int count : counts) {
      if (count != 0) {
        return false;
      }
    }
    return true;
  }
}
