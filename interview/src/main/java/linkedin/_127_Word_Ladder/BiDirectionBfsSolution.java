package linkedin._127_Word_Ladder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 6/30/2019
 */
public final class BiDirectionBfsSolution implements Solution {
  @Override
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    if (beginWord == null || endWord == null || beginWord.equals(endWord)) {
      return 0;
    }
    int len = 1;
    if (!wordList.contains(endWord)) return 0;
    Set<String> startSet = new HashSet<>(), endSet = new HashSet<>();
    final Set<String> visited = new HashSet<>(), wordSet = new HashSet<>(wordList);
    startSet.add(beginWord);
    endSet.add(endWord);
    while (!startSet.isEmpty() && !endSet.isEmpty()) {
      if (startSet.size() >= endSet.size()) {
        final Set<String> tmp = endSet;
        endSet = startSet;
        startSet = tmp;
      }
      final Set<String> nextStart = new HashSet<>();
      for (final String word : startSet) {
        final char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
          final char oldChar = chars[i];
          for (char chr = 'a'; chr <= 'z'; chr++) {
            if (chr == oldChar) continue;
            chars[i] = chr;
            final String newWord = String.valueOf(chars);
            if (endSet.contains(newWord)) {
              return len + 1;
            }
            if (!visited.contains(newWord) && wordSet.contains(newWord)) {
              visited.add(newWord);
              nextStart.add(newWord);
            }
          }
          chars[i] = oldChar;
        }
      } // end of startSet

      len++;
      startSet = nextStart;
    }

    // no such path
    return 0;
  }
}
