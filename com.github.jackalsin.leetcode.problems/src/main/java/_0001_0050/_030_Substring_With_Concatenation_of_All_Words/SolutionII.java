package _0001_0050._030_Substring_With_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhixi
 * @version 1.0 on 3/13/2020
 */
public final class SolutionII implements Solution {
  @Override
  public List<Integer> findSubstring(String s, String[] words) {
    final List<Integer> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    final Map<String, Integer> wordCount = new HashMap<>();
    for (final String word : words) {
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }
    final int wordLen = words[0].length();
    nextWord:
    for (int start = 0; start + words.length * wordLen <= s.length(); ++start) {
      final Map<String, Integer> remains = new HashMap<>(wordCount);
      for (int count = 0, nextStart = start, nextEnd = start + wordLen;
           count < words.length;
           nextStart += wordLen, nextEnd += wordLen, count++) {
        final String word = s.substring(nextStart, nextEnd);
        final int prevCount = remains.getOrDefault(word, 0);
        if (prevCount == 0) {
          continue nextWord;
        } else if (prevCount == 1) {
          remains.remove(word);
        } else {
          remains.put(word, prevCount - 1);
        }
      }
      assert remains.isEmpty();
      result.add(start);
    }
    return result;
  }
}
