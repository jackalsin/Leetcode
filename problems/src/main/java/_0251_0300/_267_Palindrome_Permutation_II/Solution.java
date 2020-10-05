package _0251_0300._267_Palindrome_Permutation_II;

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
    return tleSolution(s);
//    return acSolution(s);
  }

  private List<String> tleSolution(String s) {
    final Map<Character, Integer> charCounts = new HashMap<>();
    final List<String> result = new ArrayList<>();
    int oddCount = 0;
    for (char c: s.toCharArray()) {
      int preCount = charCounts.getOrDefault(c, 0);
      charCounts.put(c, preCount + 1);
      oddCount = (preCount + 1) % 2 == 0 ? oddCount - 1 : oddCount + 1;
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

  //---------- AC Solution
  private List<String> acSolution(String s) {
    int odd = 0;
    String mid = "";
    List<String> res = new ArrayList<>();
    List<Character> list = new ArrayList<>();
    Map<Character, Integer> map = new HashMap<>();

    // step 1. build character count map and count odds
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
      odd += map.get(c) % 2 != 0 ? 1 : -1;
    }

    // cannot form any palindromic string
    if (odd > 1) return res;

    // step 2. add half count of each character to list
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
      char key = entry.getKey();
      int val = entry.getValue();

      if (val % 2 != 0) mid += key;

      for (int i = 0; i < val / 2; i++) list.add(key);
    }

    // step 3. generate all the permutations
    getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

    return res;
  }

  void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
    if (sb.length() == list.size()) {
      // form the palindromic string
      res.add(sb.toString() + mid + sb.reverse().toString());
      sb.reverse();
      return;
    }

    for (int i = 0; i < list.size(); i++) {
      // avoid duplication
      if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

      if (!used[i]) {
        used[i] = true; sb.append(list.get(i));
        // recursion
        getPerm(list, mid, used, sb, res);
        // backtracking
        used[i] = false; sb.deleteCharAt(sb.length() - 1);
      }
    }
  }
}
