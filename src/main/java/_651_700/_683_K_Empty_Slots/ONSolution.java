package _651_700._683_K_Empty_Slots;

/**
 * @author jacka
 * @version 1.0 on 12/31/2017.
 */
public class ONSolution implements Solution {
  @Override
  public int kEmptySlots(int[] flowers, int k) {
    int[] days = new int[flowers.length];
    for (int i = 0; i < flowers.length; i++) {
      days[flowers[i] - 1] = i + 1;
    }

    int ans = Integer.MAX_VALUE;
    int left = 0, right = k + 1;

    search:
    while (right < days.length) {
      for (int i = left + 1; i < right; ++i) {
        if (days[i] < days[left] || days[i] < days[right]) {
          left = i;
          right = i + k + 1;
          continue search;
        }
      }
      ans = Math.min(ans, Math.max(days[left], days[right]));
      left = right;
      right = left + k + 1;
    }

    return ans < Integer.MAX_VALUE ? ans : -1;
  }
}
