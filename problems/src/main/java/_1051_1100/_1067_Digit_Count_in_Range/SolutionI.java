package _1051_1100._1067_Digit_Count_in_Range;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
public final class SolutionI implements Solution {
  public int digitsCount(int d, int low, int high) {
    return digitCount(d, high) - digitCount(d, low - 1);
//    return countDigit(high, d) - countDigit(low - 1, d);
  }

  private int digitCount(final int d, final int num) {
    if (num < 0) {
      return 0;
    }
    int count = 0;
    for (int times = 1; times <= num; times *= 10) {
      if (d == 0) {
        // 当 d== 0 且前面没有数字的时候，应该为0
        count += num / times / 10 * times;
        if (num / times / 10 > 0) {
          if (times > 1) {
            count -= times;
            count += Math.min(times, num % (10 * times) + 1);
          }
        }
      } else {
        //    1625, d = 2 -> [00~16]2[0-9]
        count += num / times / 10 * times
            // 162[0-5]
            + Math.min(times, Math.max(num % (10 * times) - d * times + 1, 0));
      }
      System.out.println(count);
    }
    return count;
  }

}
