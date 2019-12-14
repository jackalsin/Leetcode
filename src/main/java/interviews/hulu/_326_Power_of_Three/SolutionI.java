package interviews.hulu._326_Power_of_Three;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  private static final int MAX = (int) (Math.pow(3, 19));

  public boolean isPowerOfThree(int n) {
    return n > 0 && MAX % n == 0;
  }
}
