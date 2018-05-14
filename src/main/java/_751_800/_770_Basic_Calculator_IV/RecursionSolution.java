package _751_800._770_Basic_Calculator_IV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class RecursionSolution implements Solution {
  private static final int ADD = 1, MINUS = -1, MULTI = 1, DIVIDE = -1;

  /**
   * 158 / 158 test cases passed.
   * Status: Accepted
   * Runtime: 43 ms
   * Time Complexity: O(N^2)
   * Space Complexity: O(N)
   *
   * @param expression
   * @param evalvars
   * @param evalints
   * @return
   */
  public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
    final Map<String, Integer> map = new HashMap<>();
    for (int i = 0; i < evalvars.length; i++) {
      map.put(evalvars[i], evalints[i]);
    }
    return format(calculate(expression, map));
  }

  private List<String> format(Expression expression) {
    final List<String> result = new ArrayList<>();
    final List<Term> terms = new ArrayList<>(expression.terms.keySet());
    Collections.sort(terms, new Comparator<Term>() {

      @Override
      public int compare(Term o1, Term o2) {
        final int cmpDegree = Integer.compare(o2.vars.size(), o1.vars.size());
        if (cmpDegree == 0) {
          for (int i = 0; i < o1.vars.size(); i++) {
            int cmp = o1.vars.get(i).compareTo(o2.vars.get(i));
            if (cmp != 0) {
              return cmp;
            }
          }
        }
        return cmpDegree;
      }
    });

    for (final Term term : terms) {
      final int coeff = expression.terms.get(term);
      if (coeff == 0) continue;

      result.add(term.vars.isEmpty() ? String.valueOf(coeff) : (coeff + "*" + term.toString()));
    }

    return result;
  }

  private Expression calculate(String s, Map<String, Integer> map) {
    Expression l1 = new Expression(0), l2 = new Expression(1);
    int o1 = ADD, o2 = MULTI;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) { // constant
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = multiply(l2, new Expression(num));

      } else if (Character.isLowerCase(chr)) { // variable
        final int start = i;
        while (i + 1 < s.length() && Character.isLowerCase(s.charAt(i + 1))) {
          i++;
        }

        final String varName = s.substring(start, i + 1);

        final Term term = map.containsKey(varName) ? new Term() : new Term(Arrays.asList(varName));
        int num = map.getOrDefault(varName, 1);
        l2 = multiply(l2, new Expression(term, num));

      } else if (chr == '*') {
        o2 = MULTI;
      } else if (chr == '/') {
        o2 = DIVIDE;
      } else if (chr == '(') { // subexpression
        i++;
        final int start = i;
        int count = 1;
        for (; count != 0; i++) {
          if (s.charAt(i) == '(') {
            count++;
          } else if (s.charAt(i) == ')') {
            count--;
          }
        }
        i--;
        assert s.charAt(i) == ')';

        l2 = multiply(l2, calculate(s.substring(start, i), map));

      } else if (chr == '+' || chr == '-') {
        l1 = add(l1, l2, o1); // l1 + l2 * o1;
        o1 = chr == '+' ? ADD : MINUS;
        l2 = new Expression(1);
      }
    }

    return add(l1, l2, o1);
  }

  private Expression add(final Expression expre1, final Expression expre2, final int sign) {
    final Expression result = new Expression(expre1);
    for (Map.Entry<Term, Integer> entry : expre2.terms.entrySet()) {
      result.addTerm(entry.getKey(), sign * entry.getValue());
    }
    return result;
  }

  private Expression multiply(Expression expre1, Expression expre2) {
    final Expression result = new Expression(0);
    for (Map.Entry<Term, Integer> e1 : expre1.terms.entrySet()) {
      for (Map.Entry<Term, Integer> e2 : expre2.terms.entrySet()) {
        result.addTerm(merge(e1.getKey(), e2.getKey()), e1.getValue() * e2.getValue());
      }
    }
    return result;
  }

  private Term merge(Term key1, Term key2) {
    final List<String> vars = new ArrayList<>(key1.vars);
    vars.addAll(key2.vars);
    Collections.sort(vars);
    return new Term(vars);
  }

  private static final class Expression {
    /* term to coefficient */
    private final Map<Term, Integer> terms;

    Expression(final Term term, final int coeff) {
      terms = new HashMap<>();
      terms.put(term, coeff);
    }

    Expression(final Expression expression) {
      this.terms = new HashMap<>(expression.terms);
    }

    Expression(int constant) {
      this.terms = new HashMap<>();
      terms.put(new Term(), constant);
    }

    void addTerm(final Term term, final int coeff) {
      terms.put(term, coeff + terms.getOrDefault(term, 0));
    }
  }

  /**
   * 多项式的项
   */
  protected static final class Term {
    private static final Term C = new Term(new ArrayList<>());
    private final List<String> vars;

    Term(final List<String> vars) {
      this.vars = vars;
    }

    /**
     * 常数项
     */
    Term() {
      this.vars = new ArrayList<>();
    }

    @Override
    public int hashCode() {
      return vars.hashCode();
    }

    @Override
    public String toString() {
      return String.join("*", vars);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Term)) {
        return false;
      }

      Term other = (Term) o;
      return vars.equals(other.vars);
    }
  }
}
