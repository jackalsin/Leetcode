package interviews.linkedin._605_Can_Place_Flowers;

/**
 * @author jacka
 * @version 1.0 on 9/12/2019
 */
public final class SolutionV implements Solution {
  @Override
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (flowerbed == null || flowerbed.length == 0) {
      return n <= 0;
    }
    if (n <= 0) {
      return true;
    }
    final int len = flowerbed.length;
    for (int i = 0; i < len; ++i) {
      if (flowerbed[i] == 1) continue;
      if (i == 0) {
        if (len == 1) {
          flowerbed[i] = 1;
          n--;
        } else if (i + 1 < len && flowerbed[i + 1] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      } else if (i == len - 1) {
        if (len == 1) {
          flowerbed[i] = 1;
          n--;
        } else if (i - 1 >= 0 && flowerbed[i - 1] == 0) {
          flowerbed[i] = 1;
          n--;
        }
      } else if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
        flowerbed[i] = 1;
        n--;
      }
      if (n <= 0) {
        return true;
      }
    }
    return false;
  }
}
