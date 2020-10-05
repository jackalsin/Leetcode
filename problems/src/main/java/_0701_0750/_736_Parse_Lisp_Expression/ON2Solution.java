package _0701_0750._736_Parse_Lisp_Expression;

import java.util.HashMap;
import java.util.Map;

public final class ON2Solution implements Solution {

  private static final String ADD = "add", MULT = "mult", LET = "let";

  public int evaluate(String expression) {
    return evaluate(expression, new HashMap<>());
  }

  private int evaluate(String expression, final Map<String, Integer> vars) {

    if (expression.charAt(0) == '-' || Character.isDigit(expression.charAt(0))) {
      return Integer.parseInt(expression);
    } else if (!expression.startsWith("(")) {
      return vars.get(expression);
    }
    assert expression.charAt(0) == '(' && expression.charAt(expression.length() - 1) == ')';
    expression = expression.substring(1, expression.length() - 1);

    if (expression.startsWith(LET)) {
      int start = LET.length() + 1;
      while (true) {
        final String var = parse(expression, start);
        start += var.length() + 1;
        if (start >= expression.length()) { // is the last expression
          return evaluate(var, new HashMap<>(vars));
        }
        final String value = parse(expression, start);
        vars.put(var, evaluate(value, new HashMap<>(vars)));
        start += value.length() + 1;
      }

    } else if (expression.startsWith(ADD)) {
      final String op1 = parse(expression, ADD.length() + 1),
          op2 = parse(expression, ADD.length() + 1 + op1.length() + 1);
//      System.out.println(op1);
//      System.out.println(op2);
      return evaluate(op1, new HashMap<>(vars)) + evaluate(op2, new HashMap<>(vars));
    } else if (expression.startsWith(MULT)) {
      final String op1 = parse(expression, MULT.length() + 1), op2 = parse(expression,
          MULT.length() + 1 + op1.length() + 1);
//      System.out.println(op1);
//      System.out.println(op2);
      return evaluate(op1, new HashMap<>(vars)) * evaluate(op2, new HashMap<>(vars));
    }
    throw new IllegalArgumentException("expression = " + expression + " is not accessible.");
  }

  /**
   * Parse to next expression, and return the expression
   *
   * @param expression
   * @param start
   * @return
   */
  private String parse(String expression, int start) {
    int leftCount = 0;
    int end = start; // inclusive
    for (; end < expression.length(); end++) {
      final char chr = expression.charAt(end);
      if (chr == '(') {
        leftCount++;
      } else if (chr == ')') {
        leftCount--;
      }

      if (leftCount == 0 && chr == ' ') {
        break;
      }
    }
    return expression.substring(start, end);
  }
}
