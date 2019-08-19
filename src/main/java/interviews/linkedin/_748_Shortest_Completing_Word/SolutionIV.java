package interviews.linkedin._748_Shortest_Completing_Word;

/**
 * @author jacka
 * @version 1.0 on 8/18/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public String shortestCompletingWord(String licensePlate, String[] words) {
    if (licensePlate == null) {
      return null;
    }
    if (words == null || words.length == 0) {
      return null;
    }
    final int[] counts = getCharCount(licensePlate);
    String best = null;
    nextWord:
    for (final String word : words) {
      if (best != null && word.length() >= best.length()) continue;
      final int[] curCount = getCharCount(word);
      for (int i = 0; i < 26; ++i) {
        if (curCount[i] < counts[i]) {
          continue nextWord;
        }
      } // end of 26
      best = word;
    }
    return best;
  }

  private static int[] getCharCount(final String word) {
    final int[] count = new int[26];
    for (char chr : word.toCharArray()) {
      if (Character.isLetter(chr)) {
        chr = Character.toLowerCase(chr);
        ++count[chr - 'a'];
      }
    }
    return count;
  }
}
