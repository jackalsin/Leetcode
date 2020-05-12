package _0751_0800._792_Number_of_Matching_Subsequences;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class SolutionI implements Solution {
  /**
   * Time Complexity: O(S.length + sum(word[i).length)
   * 49 / 49 test cases passed. Status: Accepted Runtime: 110 ms
   *
   * @param S
   * @param words
   * @return
   */
  public int numMatchingSubseq(String S, String[] words) {
    final Map<Character, LinkedList<Word>> map = new HashMap<>();
    int count = 0;
    for (char chr = 'a'; chr <= 'z'; chr++) {
      map.putIfAbsent(chr, new LinkedList<>());
    }
    for (int i = 0; i < words.length; i++) {
      final String word = words[i];
      final Word w = new Word(word);
      final char chr = word.charAt(0);
      map.get(chr).add(w);
    }
    for (final char chr : S.toCharArray()) {
      final LinkedList<Word> chrList = map.get(chr);
      int size = chrList.size();
      while (size-- > 0) {
        final Word word = chrList.removeFirst();
        if (word.i == word.word.length() - 1) {
          count++;
          continue;
        }
        word.i++;
        map.get(word.word.charAt(word.i)).addLast(word);
      }
    }

    return count;
  }

  private static final class Word {
    private final String word;
    private int i = 0;

    private Word(String word) {
      this.word = word;
    }
  }
}
