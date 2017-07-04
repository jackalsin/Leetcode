package _101_150._131_Palindrome_Partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {

  public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    List<String> current = new ArrayList<>();
    dfs(result, current, s, 0);
    return result;
  }

  private static void dfs(List<List<String>> result, List<String> current,
                          String s, int start) {
    if (s.length() == 0 || start == s.length()) {
      result.add(new ArrayList<>(current));
    } else {
      for (int i = start + 1; i <= s.length(); i++) {
        if (isPalindrome(s.substring(start, i))) {
          current.add(s.substring(start, i));
          dfs(result, current, s, i);
          current.remove(current.size() - 1);
        }
      }
    }
  }

  private static boolean isPalindrome(String candidate) {
    int start = 0, end = candidate.length() - 1;
    while (start < end) {
      if (candidate.charAt(start++) != candidate.charAt(end--)) {
        return false;
      }
    }
    return true;
  }
}
