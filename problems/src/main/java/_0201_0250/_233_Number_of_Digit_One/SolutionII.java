package _0201_0250._233_Number_of_Digit_One;

/**
 * @author zhixi
 * @version 1.0 on 12/5/2020
 */
public final class SolutionII implements Solution {
  /**
   * <a href='https://leetcode.com/problems/number-of-digit-one/solution/'>solution</a>
   */
  @Override
  public int countDigitOne(int n) {
    if (n <= 0) return 0;
    int count = 0;
    for (long times = 1; times <= n; times *= 10) {
      // n = 1615 在找 10位数
      //       满格的(00 ~ 15)10
      count += n / (times * 10) * times
          // 161[0-5]
          + Math.min(Math.max(n % (times * 10) - times + 1, 0), times);
    }
    return count;
  }
}
