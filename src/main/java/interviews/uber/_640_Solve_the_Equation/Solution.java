package interviews.uber._640_Solve_the_Equation;

public class Solution {
  private static final String NO_SOLUTION = "No solution", INFINITE_SOLUTION = "Infinite solutions";

  public String solveEquation(String equation) {
    final String[] entries = equation.split("=");
    final int[] left = get(entries[0]), right = get(entries[1]);
//    System.out.println(Arrays.toString(left));
//    System.out.println(Arrays.toString(right));
    final int constant = left[0] - right[0], coe = right[1] - left[1];
    if (coe == 0 && constant == 0) {
      return INFINITE_SOLUTION;
    } else if (coe == 0 && constant != 0) { // 0x = 3
      return NO_SOLUTION;
    } else /*if (coe != 0 && constant == 0)*/ { // 3x = 0, 4x = 4
      return "x=" + (constant / coe);
    }
  }

  private static int[] get(final String equation) {
    int constant = 0, coe = 0, coeNum = 1, constantNum = 0, sign = 1;
    for (int end = 0; end < equation.length(); end++) {
      final char chr = equation.charAt(end);
      if (Character.isDigit(chr)) {
        final int start = end;
        while (end + 1 < equation.length() && Character.isDigit(equation.charAt(end + 1))) {
          end++;
        }
        constantNum = coeNum = Integer.parseInt(equation.substring(start, end + 1));
      } else if (chr == '+' || chr == '-') {
        constant += sign * constantNum;
        sign = chr == '+' ? 1 : -1;
        coeNum = 1;
        constantNum = 0;
      } else if (chr == 'x') {
        coe += sign * coeNum;
        sign = 1;
        coeNum = 1;
        constantNum = 0;
      } else {
        throw new IllegalArgumentException("Char found = " + chr);
      }
    }
    return new int[]{constant + sign * constantNum, coe};
  }
}
