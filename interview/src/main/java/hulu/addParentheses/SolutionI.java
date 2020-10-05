package hulu.addParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/4/2020
 */
public final class SolutionI implements Solution {
  private static final int PLUS = 1, MINUS = -1, MULTIPLE = 2, DIVIDE = -2;

  public List<Integer> getPossibleResult(String input) {
    final List<Integer> equation = getEquation(input);
    final List<Integer> result = new ArrayList<>();
    dfs(result, equation);
    return result;
  }

  private void dfs(List<Integer> result, final List<Integer> equation) {
    if (equation.size() == 1) {
      result.add(equation.get(0));
      return;
    }
    for (int firstIndex = 0, opIndex = 1, secondIndex = 2;
         secondIndex < equation.size();
         firstIndex += 2, opIndex += 2, secondIndex += 2) {
      final int first = equation.get(firstIndex),
          op = equation.get(opIndex),
          second = equation.get(secondIndex);
      final int res = eval(first, op, second);
      final List<Integer> nextEquation = new ArrayList<>();
      for (int i = 0; i < firstIndex; i++) {
        nextEquation.add(equation.get(i));
      }
      nextEquation.add(res);
      for (int i = secondIndex + 1; i < equation.size(); ++i) {
        nextEquation.add(equation.get(i));
      }
      dfs(result, nextEquation);
    }
  }

  private static int eval(final int a, final int op, final int b) {
    if (op == 1 || op == -1) {
      return a + op * b;
    } else if (op == 2) {
      return a * b;
    } else {
      return a / b;
    }
  }

  private static List<Integer> getEquation(final String input) {
    final List<Integer> equation = new ArrayList<>();
    for (int end = 0; end < input.length(); ++end) {
      final char chr = input.charAt(end);
      int num = chr - '0';
      while (end + 1 < input.length() && Character.isDigit(input.charAt(end + 1))) {
        num = num * 10 + input.charAt(end + 1) - '0';
        end++;
      }
      end++;
      equation.add(num);
      if (end < input.length()) {
        final char opChar = input.charAt(end);
        switch (opChar) {
          case '+':
            equation.add(PLUS);
            break;
          case '-':
            equation.add(MINUS);
            break;
          case '*':
            equation.add(MULTIPLE);
            break;
          case '/':
            equation.add(DIVIDE);
            break;
        }
      }
    }
    return equation;
  }
}
