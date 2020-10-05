package _1351_1400._1390_Four_Divisors;

/**
 * @author jacka
 * @version 1.0 on 3/21/2020
 */
public final class SolutionI implements Solution {
  public int sumFourDivisors(int[] nums) {
    int sum = 0;
    for (int num : nums) {
      int count = 2;
      int lastFactor = 1;
      for (int i = 2; (long) i * i <= num; ++i) {
        if (num % i == 0) {
          count += i == num / i ? 1 : 2;
          lastFactor = i;
        }
      } // end of for i
      if (count == 4) {
        sum += 1 + num + lastFactor + num / lastFactor;
      }
    }
    return sum;
  }
}