package _0451_0500._495_Teemo_Attacking;

public class Solution {
  /**
   * 39 / 39 test cases passed.
   * Status: Accepted
   * Runtime: 8 ms
   *
   * @param timeSeries
   * @param duration
   * @return
   */
  public int findPoisonedDuration(int[] timeSeries, int duration) {
    int total = 0, max = 0;
    for (int time : timeSeries) {
      if (time > max) {
        total += duration;
        max = time + duration;
      } else if (time + duration > max) {
        total += time + duration - max;
        max = time + duration;
      }
    }
    return total;
  }
}
