package linkedin._069_Sqrt_x;

public final class NewtonSolution implements Solution {

  public int mySqrt(final int prod) {
    assert prod >= 0;
    if (prod <= 1) {
      return prod;
    }
    long cur = prod;
    while (true) {
      if (cur * cur <= prod && (cur + 1) * (cur + 1) > prod) {
        break;
      }
//      cur = -getFx(cur, prod) / getDerive(cur) + cur;
      cur = (cur + prod / cur) / 2;
    }

    return (int) cur;
  }

  private static long getFx(final long x, final long prod) {
    return x * x - prod;
  }

  private static long getDerive(final long x) {
    return 2L * x;
  }

}
