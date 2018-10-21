package interviews.linkedin._748_Shortest_Completing_Word;

public final class SolutionII implements Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    final int charCounts[] = new int[26];
    int count = 0;

    // get sample
    for (int i = 0; i < licensePlate.length(); ++i) {
      final char chr = Character.toLowerCase(licensePlate.charAt(i));
      if (!Character.isLetter(chr)) continue;
      if (charCounts[chr - 'a'] == 0) {
        count++;
      }
      charCounts[chr - 'a']++;
    }

    // loop all words
    String str = "";
    int len = 15;
    for (final String word : words) {
      final int[] chars = new int[26];
      System.arraycopy(charCounts, 0, chars, 0, 26);
      if (match(word, count, chars)) {
        if (len > word.length()) {
          str = word;
          len = word.length();
        }
      }
    }
    return str;
  }

  private static boolean match(final String word, int count, final int[] charCounts) {
    for (char chr : word.toCharArray()) {
      if (!Character.isLetter(chr)) continue;
      if (charCounts[chr - 'a'] == 1) {
        count--;
      }
      charCounts[chr - 'a']--;
    }
    assert count >= 0;
    return count == 0;
  }
}
