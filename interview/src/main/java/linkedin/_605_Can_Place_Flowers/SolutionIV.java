package linkedin._605_Can_Place_Flowers;

/**
 * @author jacka
 * @version 1.0 on 7/22/2019
 */
public final class SolutionIV implements Solution {
  private static final int EMPTY = 0, NOT_EMPTY = 1;

  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed == null || flowerbed.length == 0 || n > flowerbed.length || n < 0) {
      return false;
    }
    final int len = flowerbed.length;
    int count = 0;
    for (int i = 0; i < len; i++) {
      if (flowerbed[i] != EMPTY) {
        continue;
      }
      if (i == 0) {
        if (i == len - 1 || (i + 1 < len && flowerbed[i + 1] == EMPTY)) {
          flowerbed[i] = 1;
          count++;
        }
      } else if (i == len - 1) {
        if (i > 0 && flowerbed[i - 1] == EMPTY) {
          flowerbed[i] = 1;
          count++;
        }
      } else {
        if (flowerbed[i - 1] == EMPTY && flowerbed[i + 1] == EMPTY) {
          flowerbed[i] = 1;
          count++;
        }
      }

    }
    return count >= n;
  }
}
