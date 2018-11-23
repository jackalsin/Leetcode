package _0101_0150._140_Word_Break_II;

import java.util.*;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public final class MemorizedSolution implements Solution {
  private Map<String, List<String>> substringToPath = new HashMap<>();

  public List<String> wordBreak(String s, List<String> wordDict) {
    return dfs(s, wordDict);
  }

  private List<String> dfs(String s, List<String> wordDict) {
    if (substringToPath.containsKey(s)) {
      return substringToPath.get(s);
    } else if (s == null || s.length() == 0) {
      return Collections.singletonList("");
    } else {
      List<String> result = new ArrayList<>();
      for (String word : wordDict) {
        if (s.startsWith(word)) {
          List<String> subPaths = dfs(s.substring(word.length()), wordDict);
          for (String subPath : subPaths) {
            result.add(new StringBuilder().append(word).append(subPath.isEmpty() ? "" : " ")
                .append(subPath).toString());
          }
        }
      }
      substringToPath.put(s, result);
      return result;
    }
  }
}
