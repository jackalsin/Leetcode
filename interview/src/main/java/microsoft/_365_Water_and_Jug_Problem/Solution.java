package microsoft._365_Water_and_Jug_Problem;

public class Solution { // TODO:
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y < z) {
      return false;
    }
    if (x == z || y == z || x + y == z) {
      return true;
    }
    return z % gcd(x, y) == 0;
  }

  private static int gcd(int x, int y) {
    if (y > x) {
      return gcd(y, x);
    }
    if (y == 0) {
      return x;
    }
    return gcd(y, x % y);
  }
}
