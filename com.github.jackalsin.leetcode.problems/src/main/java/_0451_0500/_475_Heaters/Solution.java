package _0451_0500._475_Heaters;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 11/28/2017.
 */
public class Solution {
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(heaters);
    int min = 0;
    for (int house : houses) {
      int index = Arrays.binarySearch(heaters, house);
      if (index < 0) {
        index = -(index + 1);
      }

      int distLeft = index <= 0 ? Integer.MAX_VALUE : house - heaters[index - 1];
      int distRight = index >= heaters.length ? Integer.MAX_VALUE : heaters[index] - house;
      min = Math.max(min, Math.min(distLeft, distRight));
    }
    return min;
  }
}
