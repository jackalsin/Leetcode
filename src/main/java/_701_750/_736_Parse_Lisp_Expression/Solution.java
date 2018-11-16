package _701_750._736_Parse_Lisp_Expression;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  private static final String ADD = "add", MULT = "mult", LET = "let";

  public int evaluate(String expression) {
    return evaluate(expression, new HashMap<>());
  }

  public int evaluate(String expression, final Map<String, Integer> vars) {
    if (expression.startsWith("(")) {
      expression = expression.substring(1, expression.length() - 1);
    }
    String op = null;
    for (int i = 0; i < expression.length(); i++) {
      final char chr = expression.charAt(i);
      if (chr == ' ') {
        op = expression.substring(0, i);
        break;
      }
    }


    // find last expression
    String letExpression = null;
    if (LET.equals(op)) {

      {
        int pCount = 0;
        for (int i = expression.length() - 1; i >= 0; i--) {
          final char chr = expression.charAt(i);
          if (chr == ')') {
            pCount++;
          } else if (chr == '(') {
            pCount--;
          }

          if (pCount == 0) {
            if (expression.charAt(i) == ' ') {
              letExpression = expression.substring(i + 1);
              break;
            }
          }
        }
      }
    }

//    System.out.println(letExpression);

    //op can be null
    String prev = null;

    int res = MULT.equals(op) ? 1 : 0;

    for (int i = op == null ? 0 : op.length();
         i < expression.length() - (letExpression == null ? 0 : letExpression.length());
         i++) {
      final char chr = expression.charAt(i);
      if (chr == '(') {
        final int start = i;
        int pCount = 0;
        for (; i < expression.length(); i++) {
          if (expression.charAt(i) == '(') {
            pCount++;
          } else if (expression.charAt(i) == ')') {
            pCount--;
          }

          if (pCount == 0) {
            break;
          }
        } // end of for

        final int num = evaluate(expression.substring(start, i + 1), new HashMap<>(vars));
        if (LET.equals(op)) {
          vars.put(prev, num);
          res = num;
        } else if (MULT.equals(op)) {
          res *= num;
        } else if (ADD.equals(op) || op == null) {
          res += num;
        }


      } else if (chr == '-' || Character.isDigit(chr)) {

        final int start = i;
        while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
          i++;
        }
        // i + 1 will be the )

        final int num = Integer.parseInt(expression.substring(start, i + 1));
        if (LET.equals(op)) {
          vars.put(prev, num);
          res = num; // todo:
        } else if (MULT.equals(op)) {
          res *= num;
        } else if (ADD.equals(op) || op == null) {
          res += num;
        }
        i++;
      } else if (Character.isLetter(chr)) {
        final int start = i;
        while (i + 1 < expression.length() && expression.charAt(i + 1) != ' ') {
          i++;
        }
        prev = expression.substring(start, i + 1);
        //op
        if (MULT.equals(op)) {
          res *= vars.get(prev);
        } else if (ADD.equals(op)) {
          res += vars.get(prev);
        }
      }
    }

    return LET.equals(op) ? evaluate(letExpression, new HashMap<>(vars)) : res;
  }
}
