package interviews.linkedin._605_Can_Place_Flowers;

/**
 * @author jacka
 * @version 1.0 on 10/23/2017.
 */
public final class SolutionI implements Solution {
  public boolean canPlaceFlowers(int[] flowerbed, int n) {
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        if (i == 0) {
          if ((i + 1 < flowerbed.length && flowerbed[i + 1] == 0) || (i + 1 >= flowerbed.length)) {
            flowerbed[i] = 1;
            n--;
          }
        } else if (i == flowerbed.length - 1) {
          if ((i - 1 >= 0 && flowerbed[i - 1] == 0) || (i == 0)) {
            flowerbed[i] = 1;
            n--;
          }
        } else {
          if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
            flowerbed[i] = 1;
            n--;
          }
        }
      }
    }
    return n <= 0;
  }
}
