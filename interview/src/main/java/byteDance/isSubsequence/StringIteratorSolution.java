package byteDance.isSubsequence;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 5/11/2020
 */
public final class StringIteratorSolution implements Solution {
  @Override
  public boolean[] isSubsequence(String[] s, String t) {
    if (s == null || s.length == 0) {
      return new boolean[]{};
    }
    final int n = s.length;
    final Map<Character, LinkedList<StringIterator>> charToWords = new HashMap<>();
    final boolean[] result = new boolean[n];
    for (int i = 0; i < s.length; i++) {
      final String word = s[i];
      if (word.length() == 0) result[i] = true;
      else charToWords.computeIfAbsent(word.charAt(0), k -> new LinkedList<>()).add(new StringIterator(word, i));
    }
    for (char tChar : t.toCharArray()) {
      final LinkedList<StringIterator> cur = charToWords.get(tChar);
      for (int i = 0, size = cur.size(); i < size; ++i) {
        final StringIterator itr = cur.removeFirst();
        itr.i++;
        if (itr.i == itr.word.length()) {
          result[itr.index] = true;
        } else {
          charToWords.computeIfAbsent(itr.word.charAt(itr.i), k -> new LinkedList<>()).addLast(itr);
        }
      }
    }
    return result;
  }

  private static final class StringIterator {
    private final String word;
    private int i = 0;
    private final int index;

    private StringIterator(String word, final int index) {
      this.word = word;
      this.index = index;
    }
  }

}
