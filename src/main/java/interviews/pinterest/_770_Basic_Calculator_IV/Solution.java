package interviews.pinterest._770_Basic_Calculator_IV;

import java.util.*;

public class Solution {
  public List<String> basicCalculatorIV(String s, String[] evalvars, int[] evalints) {
    final Map<String, Integer> keyToValue = new HashMap<>();
    for (int i = 0; i < evalvars.length; i++) {
      keyToValue.put(evalvars[i], evalints[i]);
    }


    Expression result = calculate(s, keyToValue);
    return format(result);
  }

  private List<String> format(Expression e) {
    final List<Term> terms = new ArrayList<>(e.termsToCoeff.keySet());
    Collections.sort(terms, (x, y) -> {
      int cmpDegree = Integer.compare(y.vars.size(), x.vars.size()); // reverse
      if (cmpDegree == 0) {
        for (int i = 0; i < x.vars.size(); i++) {
          int cmp = x.vars.get(i).compareTo(y.vars.get(i));
          if (cmp != 0) {
            return cmp;
          }
        }
      }
      return cmpDegree;
    });
    final List<String> result = new ArrayList<>();

    for (final Term t : terms) {
      final int coeff = e.termsToCoeff.get(t);
      if (coeff != 0) {
        result.add(t.vars.isEmpty() ? String.valueOf(coeff) : (coeff + "*" + t.toString()));
      }
    }

    return result;
  }

  private Expression calculate(String s, Map<String, Integer> keyToValue) {
    Expression l1 = new Expression(0), l2 = new Expression(1);
    int o1 = 1, o2 = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);

      if (Character.isDigit(chr)) {
        int num = s.charAt(i) - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = multiply(l2, new Expression(num));
      } else if (Character.isLowerCase(chr)) {
        final int start = i;
        while (i + 1 < s.length() && Character.isLowerCase(s.charAt(i + 1))) {
          i++;
        }
        final String varName = s.substring(start, i + 1);
        final Term term = keyToValue.containsKey(varName) ? new Term() : new Term(Arrays.asList(varName));
        int num = keyToValue.getOrDefault(varName, 1);

        l2 = multiply(l2, new Expression(term, num));

      } else if (chr == '+' || chr == '-') {
//        l1 = add(l1, multiply(l2, new Expression(o2)), o1);
        l1 = add(l1, l2, o1);
        o1 = chr == '+' ? 1 : -1;
        l2 = new Expression(1);
      } else if (chr == '*') {
        o2 = 1;
      } else if (chr == '(') {
        final int start = i + 1;
        int count = 1;
        for (; i + 1 < s.length() && count != 0; i++) {
          if (s.charAt(i + 1) == '(') {
            count++;
          } else if (s.charAt(i + 1) == ')') {
            count--;
          }

        }
        assert s.charAt(i) == ')';
        l2 = multiply(l2, calculate(s.substring(start, i), keyToValue));
      }
    }
    return add(l1, l2, o1);
  }

  private Expression add(Expression e1, Expression e2, int sign) {
    final Expression res = new Expression(e1);

    for (final Map.Entry<Term, Integer> e2e : e2.termsToCoeff.entrySet()) {
      res.addItem(e2e.getKey(), e2e.getValue() * sign);
    }

    return res;
  }

  private Expression multiply(Expression e1, Expression e2) {
    final Expression res = new Expression(0);

    for (Map.Entry<Term, Integer> e1e : e1.termsToCoeff.entrySet()) {
      for (Map.Entry<Term, Integer> e2e : e2.termsToCoeff.entrySet()) {
        res.addItem(merge(e1e.getKey(), e2e.getKey()), e1e.getValue() * e2e.getValue());
      }
    }

    return res;
  }

  private Term merge(Term t1, Term t2) {
    final Term t = new Term(t1.vars);
    t.vars.addAll(t2.vars);
    Collections.sort(t.vars);
    return t;
  }

  private static final class Expression {
    private final Map<Term, Integer> termsToCoeff = new HashMap<>();

    private Expression(int num) {
      termsToCoeff.put(Term.C, num);
    }

    private Expression(Expression e) {
      for (Map.Entry<Term, Integer> entry : e.termsToCoeff.entrySet()) {
        addItem(entry.getKey(), entry.getValue());
      }
    }

    public Expression(Term term, int coeff) {
      addItem(term, coeff);
    }

    private void addItem(final Term t, final int coeff) {
      termsToCoeff.put(t, termsToCoeff.getOrDefault(t, 0) + coeff);
    }
  }

  private static final class Term {
    private static final Term C = new Term();
    private final List<String> vars;

    private Term() {
      vars = new ArrayList<>();
    }

    private Term(List<String> vars) {
      this.vars = new ArrayList<>(vars);
    }

    @Override
    public boolean equals(final Object o) {
      if (o == this) {
        return true;
      }
      if (!(o instanceof Term)) {
        return false;
      }

      Term other = (Term) o;
      return vars.equals(other.vars);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(vars);
    }

    @Override
    public String toString() {
      return String.join("*", vars);
    }
  }
}
