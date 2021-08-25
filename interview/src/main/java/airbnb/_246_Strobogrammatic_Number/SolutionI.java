package airbnb._246_Strobogrammatic_Number;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 1/30/2019.
 */
public final class SolutionI implements Solution {
  private static final Map<Character, Character> VALID = new HashMap<Character, Character>() {{
    put('0', '0');
    put('1', '1');
    put('6', '9');
    put('9', '6');
    put('8', '8');
  }};

  public boolean isStrobogrammatic(String num) {
    if (num == null || num.length() == 0) {
      return false;
    }
    int left = 0, right = num.length() - 1;
    while (left <= right) {
      final char leftChar = num.charAt(left++), rightChar = num.charAt(right--);
      if (!VALID.containsKey(leftChar) || VALID.get(leftChar) != rightChar) return false;
    }
    return true;
  }
}
