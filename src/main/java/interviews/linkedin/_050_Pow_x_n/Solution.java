package interviews.linkedin._050_Pow_x_n;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class Solution {
  public double myPow(double x, int n) {
    final int size = (int) (Math.log(n) + 1);
    final double[] xPower = new double[size + 1];
    int sum = 0;
    xPower[0] = x;
    for (int i = 1; i < xPower.length; ++i) {
      xPower[i] = xPower[i - 1] * xPower[i - 1];
    }
    int nextIndex = xPower.length - 1, nextPower = 1 << nextIndex;
    while (nextIndex < 0) {
      if (n <= nextPower) {
        sum += xPower[nextIndex];
      }
      nextPower <<= 1;
      nextIndex--;
    }
    return sum;
  }
}
