package _0801_0850._809_Expressive_Words;

/**
 * @author jacka
 * @version 1.0 on 3/15/2020
 */
public final class BestSolution implements Solution {
  @Override
  public int expressiveWords(String S, String[] words) {
    int count = 0;
    final char[] sChars = S.toCharArray();
    for (final String word : words) {
      if (isValid(word.toCharArray(), sChars)) {
        count++;
      }
    }
    return count;
  }

  private boolean isValid(final char[] word, final char[] s) {
//    System.out.println("word " + Arrays.toString(word) + ", s = " + Arrays.toString(s));
    for (int i = 0, j = 0; i < s.length && j < word.length; ) {
      final int[] sPair = getCharCount(s, i),
          wPair = getCharCount(word, j);
//      System.out.println("sPair = " + Arrays.toString(sPair) + ", wPair = " + Arrays.toString(wPair));
      if (sPair[0] != wPair[0]) {
        return false;
      }
      final int sCount = sPair[1], wCount = wPair[1];
      if (sCount == wCount || (sCount >= wCount && sCount >= 3)) {
        i += sCount;
        j += wCount;
      } else {
        return false;
      }
      if (i == s.length && j == word.length) {
        return true;
      }
    }
    return false;
  }

  private static int[] getCharCount(final char[] word, int i) {
    final char sChar = word[i];
    int sCount = 1;
    while (i + 1 < word.length && word[i + 1] == sChar) {
      i++;
      sCount++;
    }
    return new int[]{sChar, sCount};
  }

}
