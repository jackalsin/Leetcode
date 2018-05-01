package _501_550._507_Perfect_Number;

public class Solution {
  /**
   * 156 / 156 test cases passed.
   * Status: Accepted
   * Runtime: 14 ms
   *
   * @param num
   * @return
   */
  public boolean checkPerfectNumber(int num) {
    if (num == 1) {
      return false;
    }
    return findAllFactor(num);
  }

  private static boolean findAllFactor(final int num) {
    int sum = 0;
    for (int factor = 2; factor <= (int) Math.sqrt(num); factor++) {
      if (num % factor == 0) {
        sum += (factor + num / factor);
      }
    }
    sum++;
    return sum == num;
  }
}
