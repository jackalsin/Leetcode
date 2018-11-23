package _0001_0050._030_Substring_With_Concatenation_of_All_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 2017/1/27.
 */
public class Solution {
  public List<Integer> findSubstring(String s, String[] words) {
    if (words == null || words.length == 0) {
      throw new IllegalArgumentException("words cannot be null or zero-length");
    } else {
      int len = words.length, wordLen = words[0].length();
      if (s == null) {
        throw new NullPointerException();
      }
      if (s.length() < len * wordLen) {
        return new ArrayList<>();
      }
      Map<String, Integer> candidates = new HashMap<>();
      for (String word : words) {
        candidates.put(word, candidates.getOrDefault(word, 0) + 1);
      }

      List<Integer> result = new ArrayList<>();
      for (int i = 0; i <= s.length() - len * wordLen; i++) {
        Map<String, Integer> curCandidates = new HashMap<>(candidates);
        for (int j = 0; j < len * wordLen; j += wordLen) {
          String candidate = s.substring(i + j, i + j + wordLen);
          int count = curCandidates.getOrDefault(candidate, 0);
          if (count == 1) {
            curCandidates.remove(candidate);
          } else if (count > 1) {
            curCandidates.put(candidate, count - 1);
          } else {
            break;
          }
        }
        if (curCandidates.isEmpty()) {
          result.add(i);
        }
      }
      return result;
    }
  }
}
