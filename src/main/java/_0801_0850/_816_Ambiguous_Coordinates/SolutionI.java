package _0801_0850._816_Ambiguous_Coordinates;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> ambiguousCoordinates(String S) {
    S = S.substring(1, S.length() - 1);
    final int n = S.length();
    final List<String> result = new ArrayList<>();
    for (int i = 1; i < n; ++i) {
      final List<String> lefts = combination(S.substring(0, i)),
          rights = combination(S.substring(i));
      for (final String l : lefts) {
        for (final String r : rights) {
          result.add(getFormat(l, r));
        }
      }
    }
    return result;
  }

  private static List<String> combination(final String str) {
    final List<String> result = new ArrayList<>();
    if (isValidIntPart(str)) {
      result.add(str);
    }
    for (int i = 1; i < str.length(); ++i) {
      final String left = str.substring(0, i),
          right = str.substring(i);
      if (isValidIntPart(left) && isValidDecimalPart(right)) {
        result.add(left + "." + right);
      }
    }
    return result;
  }

  private static boolean isValidIntPart(final String str) {
    assert str.length() >= 1;
    if (str.length() == 1) {
      return true;
    }
    return str.charAt(0) != '0';
  }

  private static boolean isValidDecimalPart(final String str) {
    assert str.length() >= 1;
    final int n = str.length();
    return str.charAt(n - 1) != '0';
  }

  private static String getFormat(final String x, final String y) {
    return "(" + x + ", " + y + ")";
  }
}
