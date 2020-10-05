package _0801_0850._849_Maximize_Distance_to_Closest_Person;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxDistToClosest(int[] seats) {
    // there is at least one 1 and one 0
    // The final result = max(distance at the beginning, distance in the middle / 2, distance at the end).
    final int n = seats.length;
    int start = -1, maxDistance = 0;
    for (int i = 0; i < n; ++i) {
      if (seats[i] == 0) continue;
      final int curDistance = start == -1 ? i : (i - start) / 2;
      if (curDistance > maxDistance) {
        maxDistance = curDistance;
      }
      start = i;
    }
    final int curDistance = n - 1 - start;
    if (curDistance > maxDistance) {
      maxDistance = curDistance;
    }
    return maxDistance;
  }
}
