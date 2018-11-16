package _601_650._640_Solve_the_Equation;

public class Solution {
  private static final char X = 'x';
  private static final String NO_SOLUTION = "No solution",
      ANS = "x=%d", INFINITE_SOLUTION = "Infinite solutions";

  public String solveEquation(String equation) {
    final String[] eqs = equation.split("=");
    final int[] left = getCoefficient(eqs[0]), right = getCoefficient(eqs[1]);
    final int co = left[0] - right[0], constant = left[1] - right[1];
    if (co == 0) {
      return constant == 0 ? INFINITE_SOLUTION : NO_SOLUTION;
    } else {
      return String.format(ANS, -constant / co);
    }
  }

  private static int[] getCoefficient(final String s) {
    int constant = 0, sign = 1, co = 0, constantNum = 0, coNum = 1;
    for (int end = 0; end < s.length(); end++) {
      final char chr = s.charAt(end);
      if (Character.isDigit(chr)) {
        final int start = end;
        while (end + 1 < s.length() && Character.isDigit(s.charAt(end + 1))) {
          end++;
        }
        coNum = constantNum = Integer.parseInt(s.substring(start, end + 1));
      } else if (chr == '-' || chr == '+') {
        constant += sign * constantNum;
        constantNum = 0;
        coNum = 1;
        sign = chr == '+' ? 1 : -1;
      } else if (chr == X) {
        co += sign * coNum;
        constantNum = 0;
        coNum = 1;
      }
    }
    return new int[]{co, constant + sign * constantNum};
  }

}
