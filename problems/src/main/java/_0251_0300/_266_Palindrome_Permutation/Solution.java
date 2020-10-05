package _0251_0300._266_Palindrome_Permutation;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
 */
public class Solution {
  public boolean canPermutePalindrome(String s) {
    Set<Character> visited = new HashSet<>();
    for (char chr: s.toCharArray()) {
      if (visited.contains(chr)) {
        visited.remove(chr);
      } else {
        visited.add(chr);
      }
    }
    return visited.size() <= 1;
  }
}
