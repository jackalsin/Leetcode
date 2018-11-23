package _0651_0700._683_K_Empty_Slots;

/**
 * @author jacka
 * @version 1.0 on 12/31/2017.
 */
public class ONSolution implements Solution {

  /**
   * The key point of this solution is to find an array [left, right], in which it always have
   * days[i] > days[left] && days[i] > days[right]
   *
   * @param flowers
   * @param k
   * @return
   */
  @Override
  public int kEmptySlots(int[] flowers, int k) {
    int[] days = new int[flowers.length];
    for (int i = 0; i < flowers.length; i++) {
      days[flowers[i] - 1] = i + 1;
    }
    int res = Integer.MAX_VALUE;
    int left = 0, right = k + 1;

    for (int i = 0; right < days.length; i++) {
      // the subarray doesn't satisfies the condition, so we update the boundary.
      if (days[i] < days[left] || days[i] <= days[right]) {
        if (i == right) res = Math.min(res, Math.max(days[left], days[right]));   //we get a valid subarray
        left = i;
        right = k + 1 + i;
      }
    }
    return (res == Integer.MAX_VALUE) ? -1 : res;
  }
}
