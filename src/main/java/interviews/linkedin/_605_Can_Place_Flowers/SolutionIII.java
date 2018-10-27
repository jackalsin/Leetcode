package interviews.linkedin._605_Can_Place_Flowers;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionIII implements Solution {
  public boolean canPlaceFlowers(int[] bed, int n) {
    assert bed.length >= 1;
    int count = 0;
    for (int i = 0; i < bed.length; ++i) {
      if (bed[i] == 1) continue;
      if (i == 0) {
        if (i + 1 < bed.length && bed[i + 1] == 0) {
          count++;
          bed[i] = 1;
        } else if (i + 1 == bed.length) {
          bed[i] = 1;
          count++;
        }
      } else if (i == bed.length - 1) {
        if (i - 1 > 0 && bed[i - 1] == 0) {
          bed[i] = 1;
          count++;
        }
      } else {
        if (bed[i - 1] == 0 && bed[i + 1] == 0) {
          bed[i] = 1;
          count++;
        }
      }
    }
    return count >= n;
  }
}
