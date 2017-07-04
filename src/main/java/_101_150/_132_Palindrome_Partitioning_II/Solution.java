package _101_150._132_Palindrome_Partitioning_II;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int minCut(String s) {
    return dfs(s, 0, new ArrayList<>());
  }

  private static int dfs(String s, final int start, List<String> curPath) {
    if (s.length() == 0 ) {
      return 0;
    } else if (start == s.length()) {
      return curPath.size() - 1;
    } else {
      int size = Integer.MAX_VALUE;
      for (int i = start + 1; i <= s.length(); i++) {
        String candidate = s.substring(start, i);
        if (isPalindrome(candidate)) {
          curPath.add(candidate);
          size = Math.min(size, dfs(s, i, curPath));
          curPath.remove(curPath.size() - 1);
        }
      }
      return size;
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
