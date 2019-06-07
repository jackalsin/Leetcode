package interviews.airbnb.roundPrice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class SolutionIII implements Solution {

  @Override
  public int[] roundMinAbs(double[] prices) {
    if (prices == null) {
      throw new NullPointerException();
    }
    final double sum = Arrays.stream(prices).sum();
    final int floorSum = Arrays.stream(prices).mapToInt(x -> (int) x).sum(),
        roundSum = (int) Math.round(sum);

    final List<Node> result = new ArrayList<>();
    for (int i = 0; i < prices.length; i++) {
      result.add(new Node(prices[i] - (int) prices[i], i));
    }
    Collections.sort(result, (x, y) -> Double.compare(y.diffToFloor, x.diffToFloor));
    final int[] dp = new int[prices.length];
    final int roundupCount = roundSum - floorSum;
    for (int i = 0; i < result.size(); i++) {
      final Node node = result.get(i);
      dp[node.originalIndex] = (int) prices[node.originalIndex] + (i < roundupCount ? 1 : 0);
    }
    return dp;
  }

  private static final class Node {
    private final double diffToFloor;
    private final int originalIndex;

    private Node(double diffToFloor, int originalIndex) {
      this.diffToFloor = diffToFloor;
      this.originalIndex = originalIndex;
    }
  }
}
