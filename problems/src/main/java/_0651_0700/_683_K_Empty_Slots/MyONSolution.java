package _0651_0700._683_K_Empty_Slots;

public class MyONSolution implements Solution {

  @Override
  public int kEmptySlots(int[] flowers, int k) {
    final int[] days = new int[flowers.length];
    for (int day = 1; day <= flowers.length; day++) {
      int positionToBloom = flowers[day - 1];
      days[positionToBloom - 1] = day;
    }

    int left = 0, right = left + k + 1, res = Integer.MAX_VALUE;
    for (int i = 0; right < flowers.length; i++) {
      if (days[i] < days[left] || days[i] <= days[right]) {
        if (i == right) {
          res = Math.min(res, Math.max(days[left], days[right]));
        }
        left = i;
        right = i + k + 1;
      } // end of if condition
    }
    return res == Integer.MAX_VALUE ? -1 : res;
  }
}
