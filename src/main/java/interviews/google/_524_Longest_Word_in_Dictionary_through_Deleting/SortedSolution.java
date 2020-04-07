package interviews.google._524_Longest_Word_in_Dictionary_through_Deleting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/6/2020
 */
public final class SortedSolution implements Solution {
  @Override
  public String findLongestWord(String s, List<String> d) {
    Collections.sort(d, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        final int lenCmp = Integer.compare(o2.length(), o1.length());
        if (lenCmp != 0) {
          return lenCmp;
        }
        return o1.compareTo(o2);
      }
    });
    String candidate = "";
    for (final String word : d) {
      if (isSubsequence(word, s)) {
        candidate = max(candidate, word);
      }
    }
    return candidate;
  }

  private static String max(String s, String word) {
    if (s.length() > word.length()) {
      return s;
    } else if (s.length() < word.length()) {
      return word;
    } else {
      return s.compareTo(word) < 0 ? s : word;
    }
  }

  /**
   * Return true iff s is subsequence of word
   */
  private static boolean isSubsequence(String subsequence, String str) {
    int sequencePtr = 0;
    for (int sPtr = 0; sequencePtr < subsequence.length() && sPtr < str.length(); ++sPtr) {
      if (subsequence.charAt(sequencePtr) == str.charAt(sPtr)) {
        sequencePtr++;
      }
    }
    return sequencePtr == subsequence.length();
  }
}
