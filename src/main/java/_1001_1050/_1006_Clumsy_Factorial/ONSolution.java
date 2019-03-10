package _1001_1050._1006_Clumsy_Factorial;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
public final class ONSolution implements Solution {
  public int clumsy(int N) {
    assert N >= 1;
    if (N <= 3) {
      return (int) return3(N);
    }
    long sum = (long) N * (N - 1) / (N - 2);
    for (int i = N - 3; i > 0; i -= 4) {
      sum += i;
      sum -= return3(i - 1);
    }
    return (int) sum;
  }

  private static long return3(final int N) {
    if (N == 0) {
      return 0;
    } else if (N == 1) {
      return 1;
    } else if (N == 2) {
      return 2;
    } else if (N == 3) {
      return 6;
    }
    return (long) N * (N - 1) / (N - 2);
  }
}
