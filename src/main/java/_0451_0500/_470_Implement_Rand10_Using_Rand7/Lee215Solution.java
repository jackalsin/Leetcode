package _0451_0500._470_Implement_Rand10_Using_Rand7;

import java.util.Stack;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
public final class Lee215Solution extends Solution {
  private final Stack<Integer> cache = new Stack<>();

  /**
   * @see
   * <a href='https://leetcode.com/problems/implement-rand10-using-rand7/discuss/151567/C%2B%2BJavaPython-1.183-Call-of-rand7-Per-rand10'>1.183 call</a>
   */
  public int rand10() {
    while (cache.empty()) generate();
    return cache.pop();
  }

  void generate() {
    int n = 19;
    long cur = 0, range = (long) Math.pow(7, n);
    for (int i = 0; i < n; ++i) cur += (long) Math.pow(7, i) * (rand7() - 1);
    while (cur < range / 10 * 10) {
      cache.push((int) (cur % 10 + 1));
      cur /= 10;
      range /= 10;
    }
  }
}
