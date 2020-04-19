package _1401_1450._1417_Reformat_The_String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  public String reformat(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    final List<Character> digits = new ArrayList<>(),
        chars = new ArrayList<>();
    for (int i = 0; i < s.length(); ++i) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        digits.add(chr);
      } else {
        chars.add(chr);
      }
    }
    List<Character> l1 = digits.size() > chars.size() ? digits : chars,
        l2 = digits.size() > chars.size() ? chars : digits;
    final StringBuilder sb = new StringBuilder();
    while (!l1.isEmpty()) {
      final char toRemove = l1.remove(l1.size() - 1);
      sb.append(toRemove);
      final List<Character> tmp = l2;
      l2 = l1;
      l1 = tmp;
    }
    return sb.length() == s.length() ? "" : sb.toString();
  }
}
