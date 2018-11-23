package _0351_0400._383_Ransom_Note;

public class Solution {

  public boolean canConstruct(String ransomNote, String magazine) {
    final int[] map = new int[128];
    for (final char chr : magazine.toCharArray()) {
      map[chr]++;
    }
    for (final char chr : ransomNote.toCharArray()) {
      map[chr]--;
      if (map[chr] < 0) {
        return false;
      }
    }
    return true;
  }

}
