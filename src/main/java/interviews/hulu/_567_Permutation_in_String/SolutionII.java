package interviews.hulu._567_Permutation_in_String;

/**
 * @author jacka
 * @version 1.0 on 2/23/2020
 */
public final class SolutionII implements Solution {
  @Override
  public boolean checkInclusion(String s1, String s2) {
    final int[] counts = new int[26];
    final char[] chars1 = s1.toCharArray(),
        chars2 = s2.toCharArray();
    final int len1 = s1.length(), len2 = s2.length();
    if (len1 > len2) {
      return false;
    }
    for (int i = 0; i < len1; ++i) {
      counts[chars1[i] - 'a']++;
      counts[chars2[i] - 'a']--;
    }
    if (isAllZero(counts)) {
      return true;
    }
    for (int i = len1; i < len2; ++i) {
      counts[chars2[i] - 'a']--;
      counts[chars2[i - len1] - 'a']++;
      if (isAllZero(counts)) {
        return true;
      }
    }
    return false;
  }

  private static boolean isAllZero(final int[] counts) {
    for (int c : counts) {
      if (c != 0) {
        return false;
      }
    }
    return true;
  }
}
