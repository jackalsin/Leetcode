package _251_300._267_Palindrome_Permutation_II;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
 */
public class Solution {
  public List<String> generatePalindromes(String s) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    final List<String> result = new ArrayList<>();
    int oddCount = 0;
    for (char c: s.toCharArray()) {
      int preCount = charCounts.getOrDefault(c, 0);
      charCounts.put(c, preCount + 1);
      oddCount = preCount == 0 ? oddCount + 1 : oddCount - 1;
    }

    if (oddCount > 1) return result;
    Character mid = null;
    List<Character> candidates = new ArrayList<>();
    for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
      char key = entry.getKey();
      int value = entry.getValue();
      if (value % 2 == 1) mid = key;
      for (int i = 0; i < value / 2; i++) {
        candidates.add(key);
      }
    }
    boolean[] visited = new boolean[candidates.size()];

    getPermutation(result, mid, new StringBuilder(), candidates, visited);
    return result;
  }

  private void getPermutation(List<String> result, Character mid, StringBuilder half,
                              List<Character> candidates, boolean[] visited) {
    if (half.length() == candidates.size()) {
      result.add(half.toString() + (mid == null ? "" : mid) + half.reverse());
      half.reverse();
    } else {
      for (int i = 0; i < candidates.size(); ++i) {
        if (i > 0 && candidates.get(i).equals(candidates.get(i - 1)) && !visited[i - 1]) continue;
        if (!visited[i]) {
          visited[i] = true;
          half.append(candidates.get(i));
          getPermutation(result, mid, half, candidates, visited);
          half.deleteCharAt(half.length() - 1);
          visited[i] = false;
        }
      }
    }
  }
}
