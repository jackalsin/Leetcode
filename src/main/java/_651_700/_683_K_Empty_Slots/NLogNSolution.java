package _651_700._683_K_Empty_Slots;

import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 12/31/2017.
 */
public class NLogNSolution implements Solution {

  public int kEmptySlots(int[] flowers, int k) {
    TreeSet<Integer> bloomed = new TreeSet<>();

    for (int dayMinus1 = 0; dayMinus1 < flowers.length; dayMinus1++) {
      Integer lower = bloomed.lower(flowers[dayMinus1]);
      Integer higher = bloomed.higher(flowers[dayMinus1]);
      if ((lower != null && flowers[dayMinus1] - lower == k + 1) ||
          (higher != null && higher - flowers[dayMinus1] == k + 1)) {
        return dayMinus1 + 1;
      }
      bloomed.add(flowers[dayMinus1]);
    }
    return -1;
  }
}
