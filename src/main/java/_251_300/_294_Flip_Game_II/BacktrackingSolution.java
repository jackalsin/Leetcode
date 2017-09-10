package _251_300._294_Flip_Game_II;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 9/9/2017.
 */
public class BacktrackingSolution implements Solution {
  @Override
  public boolean canWin(String s) {
    if (s == null || s.length() < 2) {
      return false;
    }
    Map<String, Boolean> visited = new HashMap<>();
    return canWin(s, visited);
  }

  private static boolean canWin(String s, Map<String, Boolean> visited) {
    Boolean result = visited.get(s);
    if (result != null) {
      return result;
    }
    for (int i = 1; i < s.length(); ++i) {
      if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
        final String opponentString = s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length());
        boolean opponentResult = canWin(opponentString, visited);
        visited.put(opponentString, opponentResult);
        if (!opponentResult) {
          return true;
        }
      }
    }
    return false;
  }
}
