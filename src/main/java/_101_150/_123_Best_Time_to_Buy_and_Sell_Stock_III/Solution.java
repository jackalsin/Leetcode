package _101_150._123_Best_Time_to_Buy_and_Sell_Stock_III;

import java.util.PriorityQueue;

/**
 * @author jacka
 * @version 1.0 on 6/25/2017.
 */
public class Solution {
  public int maxProfit(int[] prices) {
    if (prices.length == 0) return 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int curBuyPrice = prices[0];
    int prevPrice = prices[0];
    for(int i = 1; i < prices.length + 1; i++) {
      int curPrice = i == prices.length ? curBuyPrice :prices[i];
      if (prevPrice >= curPrice) {
        // sell
        int curBias = prevPrice - curBuyPrice;
        curBuyPrice = curPrice;
        if (curBias < 0) continue;
        if (pq.size() < 2) {
          pq.offer(curBias);
        } else {
          if (curBias > pq.peek()) {
            pq.poll();
            pq.offer(curBias);
          }
        }
      }
      prevPrice = curPrice;
    }
    int sum = 0;
    while (!pq.isEmpty()) {
      sum += pq.poll();
    }
    return sum;
  }
}
