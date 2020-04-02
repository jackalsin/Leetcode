package interviews.google._679_24_Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/1/2020
 */
public final class SolutionI implements Solution {
  private final Map<List<FenShu>, Boolean> cache = new HashMap<>();
  private static final FenShu TARGET = new FenShu(24);

  public boolean judgePoint24(int[] nums) {
    final List<FenShu> expression = new ArrayList<>();
    for (int n : nums) {
      expression.add(new FenShu(n));
    }
    return judgePoint24(expression);
  }

  private boolean judgePoint24(final List<FenShu> expression) {
    if (cache.containsKey(expression)) {
      return cache.get(expression);
    }
    if (expression.size() == 1) {
      return expression.get(0).equals(TARGET);
    }
    for (int i = 0; i < expression.size(); ++i) {
      for (int j = 0; j < expression.size(); ++j) {
        if (i == j) continue;
        for (int op = 0; op < 4; op++) {
          final List<FenShu> next = new ArrayList<>();
          for (int k = 0; k < expression.size(); k++) {
            if (k != i && k != j) {
              next.add(expression.get(k));
            }
          }
          if (op == 0) {
            final FenShu fenshu = expression.get(i).add(expression.get(j));
            next.add(fenshu);
          } else if (op == 1) {
            next.add(expression.get(i).minus(expression.get(j)));
          } else if (op == 2) {
            next.add(expression.get(i).multiply(expression.get(j)));
          } else {
            next.add(expression.get(i).divide(expression.get(j)));
          }
          if (judgePoint24(next)) {
            return true;
          }
        }
      }
    }
    cache.put(expression, false);
    return false;
  }

  private static final class FenShu {
    private final int fenZi, fenMu;

    private FenShu(int fenZi) {
      this.fenZi = fenZi;
      this.fenMu = 1;
    }

    private FenShu(int fenZi, int fenMu) {
      if (fenZi == 0) {
        this.fenZi = 0;
        this.fenMu = 1;
        return;
      }
      if (fenMu < 0) {
        fenZi = -fenZi;
        fenMu = -fenMu;
      }
      final int gcd = gcd(Math.abs(fenZi), Math.abs(fenMu));
      this.fenZi = fenZi / gcd;
      this.fenMu = fenMu / gcd;
    }

    private FenShu add(FenShu other) {
      final int fenzi = fenZi * other.fenMu + other.fenZi * fenMu,
          fenmu = fenMu * other.fenMu;
      return new FenShu(fenzi, fenmu);
    }

    private FenShu minus(FenShu other) {
      final int fenzi = fenZi * other.fenMu - other.fenZi * fenMu,
          fenmu = fenMu * other.fenMu;
      return new FenShu(fenzi, fenmu);
    }

    private FenShu multiply(FenShu other) {
      return new FenShu(fenZi * other.fenZi, fenMu * other.fenMu);
    }

    private FenShu divide(FenShu other) {
      return multiply(new FenShu(other.fenMu, other.fenZi));
    }

    private static int gcd(int a, int b) {
//      System.out.printf("a = %d, b = %d\n", a, b);
      assert a > 0 && b >= 0;
      if (a < b) {
        return gcd(b, a);
      }
      while (b != 0) {
        final int c = b;
        b = a % b;
        a = c;
      }
      return a;
    }

    @Override
    public String toString() {
      return String.format("%d/%d", fenZi, fenMu);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof FenShu)) return false;
      FenShu fenShu = (FenShu) o;
      if (fenZi != fenShu.fenZi) return false;
      return fenMu == fenShu.fenMu;
    }

    @Override
    public int hashCode() {
      int result = fenZi;
      result = 31 * result + fenMu;
      return result;
    }
  }
}
