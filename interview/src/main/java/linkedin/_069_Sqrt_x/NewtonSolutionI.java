package linkedin._069_Sqrt_x;

/**
 * @author jacka
 * @version 1.0 on 8/8/2021
 */
public final class NewtonSolutionI implements Solution {
  @Override
  public int mySqrt(int x) {
    long cur = 1;
    while (true) {
      if (cur * cur <= x && x < (cur + 1) * (cur + 1)) return (int) cur;
      cur = (cur + x / cur) / 2;
    }
  }
}
