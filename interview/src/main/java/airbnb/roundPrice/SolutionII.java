package airbnb.roundPrice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class SolutionII implements Solution {

  /**
   * @param prices
   * @return
   */
  public int[] roundMinAbs(final double[] prices) {
    if (prices == null) {
      throw new NullPointerException();
    }
    double sum = Arrays.stream(prices).sum();
    final int floorSum = Arrays.stream(prices).mapToInt(x -> (int) x).sum(),
        roundSum = (int) Math.round(sum);
    final List<Node> reorderPrices = new ArrayList<>();
    for (int i = 0; i < prices.length; i++) {
      reorderPrices.add(new Node(i, prices[i] - (int) prices[i]));
    }
    reorderPrices.sort((x, y) -> Double.compare(y.diffToFloor, x.diffToFloor));
    final int roundUpNum = roundSum - floorSum;
    final int[] result = new int[prices.length];
    for (int i = 0; i < prices.length; i++) {
      final Node node = reorderPrices.get(i);
      result[node.originalIndex] = (int) prices[node.originalIndex] + (i < roundUpNum ? 1 : 0);
    }
    return result;
  }

  private static final class Node {
    private final int originalIndex;
    private final double diffToFloor;

    private Node(int originalIndex, double diffToFloor) {
      this.originalIndex = originalIndex;
      this.diffToFloor = diffToFloor;
    }
  }
}
