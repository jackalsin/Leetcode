package _401_450._409_Longest_Palindrome;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/12/2017.
 */
public class Solution {
  public int longestPalindrome(String s) {
    final Set<Character> seen = new HashSet<>();
    int count = 0;
    for (char chr : s.toCharArray()) {
      if (seen.contains(chr)) {
        seen.remove(chr);
        count++;
      } else {
        seen.add(chr);
      }
    }
    return seen.isEmpty() ? count * 2 : count * 2 + 1;
  }
}
