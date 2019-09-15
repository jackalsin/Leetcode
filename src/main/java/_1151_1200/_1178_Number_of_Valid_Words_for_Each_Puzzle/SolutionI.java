package _1151_1200._1178_Number_of_Valid_Words_for_Each_Puzzle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/31/2019
 */
public final class SolutionI implements Solution {

  public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
    final int[] wordToCharSet = getCharSet(words);
    final List<Integer> result = new ArrayList<>();
    for (final String puzzle : puzzles) {
      int count = 0;
      final char firstChar = puzzle.charAt(0);
      final int firstCharBit = 1 << (firstChar - 'a');
      final int puzzleCharSet = getCharSet(puzzle.toCharArray());
      for (int wordCharSet : wordToCharSet) {
        if (
            (wordCharSet | puzzleCharSet) != puzzleCharSet
                || (wordCharSet & firstCharBit) != firstCharBit
        ) {
          continue;
        }
        count++;
      }
      result.add(count);
    }
    return result;
  }

  private int[] getCharSet(final String[] words) {
    final int[] result = new int[words.length];
    for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
      String word = words[wordIndex];
      for (int i = 0; i < word.length(); ++i) {
        result[wordIndex] |= (1 << (word.charAt(i) - 'a'));
      }
    }
    return result;
  }

  private int getCharSet(final char[] chars) {
    int res = 0;
    for (char chr : chars) {
      res |= (1 << (chr - 'a'));
    }
    return Integer.bitCount(res) <= 7 ? res : 0;
  }

}
