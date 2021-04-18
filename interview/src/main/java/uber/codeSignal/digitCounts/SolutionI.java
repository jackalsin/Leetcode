package uber.codeSignal.digitCounts;

/**
 * @author jacka
 * @version 1.0 on 4/18/2021
 */
public final class SolutionI implements Solution {
  public int digitCounts(int n) {
    int res = 0;
    for (int d : new int[]{0, 2, 4}) {
      res += getCount(n, d);
    }
    return res;
  }

  static int getCount(int num, final int d) {
    if (d == 0 && num < 10) return 1;
    int res = 0;
    for (long times = 1; times <= num; times *= 10) {
      if (d == 0) {
        res += num / times / 10 * times;
        if (num / times / 10 > 0) {
          if (times > 1) {
            res -= times;
            res += Math.min(times, num % (10 * times) + 1);
          } else {
            res++;
          }
        }
      } else { // d != 0
        res += num / times / 10 * times
            + Math.min(times, Math.max(num % (10 * times) - d * times + 1, 0));
      }
    }
    return res;
  }
}
