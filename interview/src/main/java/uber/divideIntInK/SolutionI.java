package uber.divideIntInK;

/**
 * @author jacka
 * @version 1.0 on 4/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int divideIntToK(int num, int K) {
    final char[] chars = String.valueOf(num).toCharArray();
    if (chars.length <= K) {
      return num;
    }
    final int len = chars.length;
    int res = 0, cur = 0, k = 0;
    for (int i = 0; i < len; ++i) {
      cur += chars[i] - '0';
      ++k;
      if (k == K) {
        res = res * 10 + cur;
        cur = 0;
        k = 0;
      }
    }
    if (k != 0) {
      res = res * 10 + cur;
    }
//    System.out.println(res);
    return divideIntToK(res, K);
  }
}
