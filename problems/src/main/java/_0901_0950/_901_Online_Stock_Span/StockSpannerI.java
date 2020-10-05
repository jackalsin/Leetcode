package _0901_0950._901_Online_Stock_Span;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 5/19/2020
 */
public final class StockSpannerI implements StockSpanner {
  /**
   * {price, 之前有多少个小于等于自己的连续price}
   */
  private final Deque<int[]> stack = new ArrayDeque<>();

  public int next(int price) {
    int res = 1;
    while (!stack.isEmpty() && stack.peek()[0] <= price) {
      res += stack.pop()[1];
    }
    stack.push(new int[]{price, res});
    return res;
  }
}
