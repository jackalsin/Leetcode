package _1401_1450._1405_Longest_Happy_String;


/**
 * @author jacka
 * @version 1.0 on 4/4/2020
 */
public final class SolutionI implements Solution {

  public String longestDiverseString(int a, int b, int c) {
    return helper(a, b, c, "a", "b", "c");
  }

  private static String helper(final int a, final int b, final int c, final String aStr, final String bStr,
                               final String cStr) {
    // ===== 保证 a >= b >= c
    if (a < b) {
      return helper(b, a, c, bStr, aStr, cStr);
    }
    if (b < c) {
      return helper(a, c, b, aStr, cStr, bStr);
    }
    if (b == 0) {
      return repeat(aStr, Math.min(2, a));
    }
    // ===== 保证结束
    // 如果a放两个，那么要节约地放，这样才能使得a放的更多，
    // 如果最大值没发生交替，append一个只是为了分隔相同的最大值
    // 如果发生交替，那就不用append了
    final int aUsed = Math.min(2, a), bUsed = a - aUsed >= b ? 1 : 0;
    return repeat(aStr, aUsed) + repeat(bStr, bUsed) + helper(a - aUsed, b - bUsed, c, aStr, bStr, cStr);
  }

  private static String repeat(final String str, final int count) {
    final StringBuilder sb = new StringBuilder();
    for (int i = 0; i < count; ++i) {
      sb.append(str);
    }
    return sb.toString();
  }

}
