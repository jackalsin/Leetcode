package interviews.hulu._567_Permutation_in_String;

/**
 * @author jacka
 * @version 1.0 on 12/19/2019
 */
public final class SolutionI implements Solution {
  private static final int N = 26;

  public boolean checkInclusion(String s1, String s2) {
    final int[] charCounts = new int[N];
    final int len1 = s1.length(), len2 = s2.length();
    if (len1 > len2) {
      return false;
    }
    final char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
    for (int i = 0; i < len1; ++i) {
      charCounts[chars1[i] - 'a']++;
      charCounts[chars2[i] - 'a']--;
    }
    if (isAllZero(charCounts)) return true;
    for (int i = len1; i < len2; ++i) {
      charCounts[chars2[i] - 'a']--;
      charCounts[chars2[i - len1] - 'a']++;
      if (isAllZero(charCounts)) return true;
    }
    return false;
  }

  private static boolean isAllZero(final int[] charCounts) {
    for (int count : charCounts) {
      if (count != 0) return false;
    }
    return true;
  }

}
