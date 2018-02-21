package interviews.uber._266_Palindrome_Permutation;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  public boolean canPermutePalindrome(String s) {
    final Set<Character> dangling = new HashSet<>();
    for (final char chr : s.toCharArray()) {
      if (!dangling.contains(chr)) {
        dangling.add(chr);
      } else {
        dangling.remove(chr);
      }
    }
    return dangling.size() <= 1;
  }
}
