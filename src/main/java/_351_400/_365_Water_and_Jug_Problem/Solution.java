package _351_400._365_Water_and_Jug_Problem;

/**
 * @author jacka
 * @version 1.0 on 10/26/2017.
 */
public class Solution {
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y < z) {
      return false;
    }
    if (x == z || y == z || x + y == z) {
      return true;
    }
    return z % steinAlgorithm(x, y) == 0;
  }

  private static int gcd(int a, int b) {
    if (a < b) {
      return gcd(b, a);
    }
    if (b != 0) {
      return gcd(b, a % b);
    }
    return a;
  }

  private static int steinAlgorithm(int a, int b) {
    if (a < b) {
      return steinAlgorithm(b, a);
    } else if (b == 0) {
      return a;
    } else if (isEven(a) && isEven(b)) {
      return 2 * steinAlgorithm(a / 2, b / 2);
    } else if (isEven(a)) {
      return steinAlgorithm(a / 2, b);
    } else if (isEven(b)) {
      return steinAlgorithm(a, b / 2);
    } else {
      return steinAlgorithm((a - b) / 2, b);
    }
  }

  private static boolean isEven(int a) {
    return (a & 1) == 0;
  }
}
