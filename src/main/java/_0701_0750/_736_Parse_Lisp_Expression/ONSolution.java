package _0701_0750._736_Parse_Lisp_Expression;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/19/2020
 */
public final class ONSolution implements Solution {
  private static final String ADD = "add", MULT = "mult", LET = "let";
  private static final int ADD_VAL = 1, MULT_VAL = 2, LET_VAL = 3;

  public int evaluate(String expression) {
    int o1 = ADD_VAL, l1 = 0;
    /* true iff <c>i</c> pointing to an term that is a variable or the expression in operation Let*/
    boolean isVarOrFinalExpression = false;
    final Deque<int[]> stack = new ArrayDeque<>();
    final Deque<String> varNameStack = new ArrayDeque<>();
    final Deque<Map<String, Integer>> varStack = new ArrayDeque<>() {{
      push(new HashMap<>());
    }};
    for (int i = 0; i < expression.length(); ++i) {
      final char chr = expression.charAt(i);
      if (chr == '(') { // start
        stack.push(new int[]{o1, l1});
        assert varStack.peek() != null;
        varStack.push(new HashMap<>(varStack.peek()));
      } else if (expression.startsWith(ADD, i)) {
        o1 = ADD_VAL;
        l1 = 0;
        i += ADD.length() - 1;
        isVarOrFinalExpression = false;
      } else if (expression.startsWith(MULT, i)) {
        o1 = MULT_VAL;
        l1 = 1;
        i += MULT.length() - 1;
        isVarOrFinalExpression = false;
      } else if (expression.startsWith(LET, i)) {
        o1 = LET_VAL;
        i += LET.length() - 1;
        isVarOrFinalExpression = false;
      } else if (chr == '-' || Character.isDigit(chr)) { // is digit
        int sign = chr == '-' ? -1 : 1, num = chr == '-' ? 0 : chr - '0';
        while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
          num = num * 10 + expression.charAt(i + 1) - '0';
          i++;
        }
        if (o1 == ADD_VAL) {
          l1 += sign * num;
        } else if (o1 == MULT_VAL) {
          l1 *= sign * num;
        } else {
          assert o1 == LET_VAL;
          assert varStack.peek() != null;
          if (isVarOrFinalExpression) {
            l1 = sign * num;
          } else {
            varStack.peek().put(varNameStack.pop(), sign * num);
          }
        }
      } else if (Character.isLetter(chr)) { // variable
        final int start = i;
        while (i + 1 < expression.length() && Character.isLetterOrDigit(expression.charAt(i + 1))) {
          i++;
        }
        final String varName = expression.substring(start, i + 1);
        if (o1 == LET_VAL) {
          final var curVarToVal = varStack.peek();
          assert curVarToVal != null;
          if (isVarOrFinalExpression) {
            varNameStack.push(varName);
            l1 = curVarToVal.getOrDefault(varName, 0);
          } else {
            curVarToVal.put(varNameStack.pop(), curVarToVal.get(varName));
          }
        } else if (o1 == ADD_VAL) {
          assert varStack.peek() != null;
          l1 += varStack.peek().get(varName);
        } else {
          assert varStack.peek() != null;
          l1 *= varStack.peek().get(varName);
        }
      } else if (chr == ')') {
        final int[] prev = stack.pop();
        final int prevOp = prev[0], prevL1 = prev[1];
        o1 = prevOp;
        varStack.pop();
        if (prevOp == ADD_VAL) {
          l1 = prevL1 + l1;
        } else if (prevOp == MULT_VAL) {
          l1 = prevL1 * l1;
        } else {
          assert prevOp == LET_VAL;
          if (varNameStack.isEmpty()) { // is the final expression
            // l1 = l1;
          } else {
            varStack.peek().put(varNameStack.pop(), l1);
          }
        }
      } else if (chr == ' ') {
        isVarOrFinalExpression = !isVarOrFinalExpression;
      }
    }
    return l1;
  }
}
