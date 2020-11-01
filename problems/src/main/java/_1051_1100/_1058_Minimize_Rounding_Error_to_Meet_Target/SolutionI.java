package _1051_1100._1058_Minimize_Rounding_Error_to_Meet_Target;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 10/31/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String minimizeError(String[] prices, int target) {
    final Queue<Double> diff = new PriorityQueue<>();
    for (final String price : prices) {
      final double num = Double.parseDouble(price);
      final int curLow = (int) Math.floor(num),
          curHigh = (int) Math.ceil(num);
      if (curHigh != curLow) {
        diff.add(curHigh - num);
      }
      target -= curLow;
    }

    if (target < 0 || target > diff.size()) {
      return "-1";
    }
    double res = 0;
    while (target > 0) {
      res += diff.remove();
      target--;
    }
    while (!diff.isEmpty()) {
      res += (1 - diff.remove());
    }
    return String.format("%.3f", res);
  }
}
