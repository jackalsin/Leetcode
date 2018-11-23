package _0701_0750._748_Shortest_Completing_Word;

public final class NormalSolution implements Solution {
  public String shortestCompletingWord(String licensePlate, String[] words) {
    final int[] lpCharCount = getCharCount(licensePlate);
    String res = "";
    int minLen = Integer.MAX_VALUE;

    for (final String word : words) {
      final int[] wordCharCount = getCharCount(word);
      if (word.length() < minLen && isGreaterOrEqual(wordCharCount, lpCharCount)) {
        minLen = word.length();
        res = word;
      }
    }
    return res;
  }

  private boolean isGreaterOrEqual(int[] wordCharCount, int[] lpCharCount) {
    for (int i = 0; i < wordCharCount.length; i++) {
      if (wordCharCount[i] < lpCharCount[i]) {
        return false;
      }
    }
    return true;
  }

  private int[] getCharCount(String word) {
    final int[] chars = new int[26];
    for (char chr : word.toCharArray()) {
      if (Character.isLetter(chr)) {
        chr = Character.toLowerCase(chr);
        chars[chr - 'a']++;
      }
    }
    return chars;
  }

}
