package linkedin._605_Can_Place_Flowers;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionII implements Solution {
  public boolean canPlaceFlowers(int[] bed, int n) {
    for (int i = 0; i < bed.length; ++i) {
      if (bed[i] == 0 && (i == 0 || bed[i - 1] == 0) && (i == bed.length - 1 || bed[i + 1] == 0)) {
        bed[i] = 1;
        n--;
      }
    }
    return n <= 0;
  }
}
