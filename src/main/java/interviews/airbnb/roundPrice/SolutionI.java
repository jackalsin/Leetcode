package interviews.airbnb.roundPrice;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class SolutionI implements Solution {

  /**
   * @param prices
   * @return
   */
  public int[] roundMinAbs(final double[] prices) {
    double sum = 0;
    int sumToFloor = 0;
    final Node[] nodes = new Node[prices.length];
    for (int i = 0; i < nodes.length; i++) {
      sum += prices[i];
      final int floorPrice = (int) prices[i];
      sumToFloor += floorPrice;
      nodes[i] = new Node(prices[i], prices[i] - floorPrice, i);
    }
    // 按照diff从大到小排
    Arrays.sort(nodes, (x, y) -> Double.compare(y.diffToFloor, x.diffToFloor));
    final int n = prices.length;
    final int[] result = new int[n];
    final int sumRound = (int) Math.round(sum), diff = sumRound - sumToFloor;
    for (int i = 0; i < n; i++) {
      final int index = nodes[i].index;
      result[index] = (int) nodes[i].price + (diff > i ? 1 : 0);
    }
    return result;
  }

  private static final class Node {
    private final double price, diffToFloor;
    private final int index;

    private Node(double price, double diffToFloor, int index) {
      this.price = price;
      this.diffToFloor = diffToFloor;
      this.index = index;
    }
  }
}
