package interviews.hulu._383_Ransom_Note;

/**
 * @author jacka
 * @version 1.0 on 2/10/2020
 */
public final class SolutionII implements Solution {
  @Override
  public boolean canConstruct(String ransomNote, String magazine) {
    final int[] charCount = new int[26];
    for (final char chr : magazine.toCharArray()) {
      charCount[chr - 'a']++;
    }
    for (final char chr : ransomNote.toCharArray()) {
      charCount[chr - 'a']--;
      if (charCount[chr - 'a'] < 0) {
        return false;
      }
    }
    return true;
  }
}
