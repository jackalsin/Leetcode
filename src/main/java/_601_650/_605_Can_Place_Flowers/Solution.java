package _601_650._605_Can_Place_Flowers;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    if (n == 0) {
      return true;
    }
    for (int pos = 0; pos < flowerbed.length; ++pos) {
      if (flowerbed[pos] == 1) {
        continue;
      }
      assert flowerbed[pos] == 0;
      if ((pos == 0 || flowerbed[pos - 1] != 1)
          && (pos == flowerbed.length - 1 || flowerbed[pos + 1] != 1)) {
        flowerbed[pos] = 1;
        n--;
        if (n == 0) {
          return true;
        }
      }
    }
    return false;
  }

}
