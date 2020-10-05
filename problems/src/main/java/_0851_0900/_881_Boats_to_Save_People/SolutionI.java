package _0851_0900._881_Boats_to_Save_People;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 9/15/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    final int n = people.length;
    int result = 0;
    for (int i = 0, j = n - 1; i <= j; --j, result++) {
      if (people[i] + people[j] <= limit) {
        ++i;
      }
    }
    return result;
  }
}
