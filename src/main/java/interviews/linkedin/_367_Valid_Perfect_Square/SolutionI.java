package interviews.linkedin._367_Valid_Perfect_Square;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionI implements Solution {
  /**
   * 0ms Solution
   */
  public boolean isPerfectSquare(int num) {
    if (num <= 0) {
      return false;
    }
    long x = num;
    while (x * x >= num) {
      if (x * x == num) {
        return true;
      }
      x = (x + num / x) / 2;
    }
    return false;
  }

  /**
   * Runtime: 4 ms
   */
  boolean squareSolution(int num) {
    for (long i = 1; i * i <= (long) num; ++i) {
      if (num == i * i) {
        return true;
      } else if ((long) num < i * i) {
        return false;
      }
    }
    return false;
  }

}
