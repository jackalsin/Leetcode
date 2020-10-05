package _0301_0350._343_Integer_Break;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class Solution {
  public int integerBreak(int n) {
    final int[] products = new int[n + 1];
    products[1] = 0;
    for (int i = 2; i <= n; ++i) {
      for (int j = 1; j * 2 <= i; ++j) {
        products[i] = Math.max((i - j) * j, Math.max(products[i - j] * j, products[i]));
      }
    }
    return products[n];
  }
}
