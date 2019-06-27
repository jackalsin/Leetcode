package interviews.linkedin._050_Pow_x_n;

import java.util.HashMap;
import java.util.Map;

/**
 * 300 / 300 test cases passed. Status: Accepted Runtime: 22 ms
 *
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class MemoSolution implements Solution {

  public double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    } else if (n > 0) {
      return myPow(x, n, new HashMap<>());
    } else {
      return 1d / myPow(x, -n, new HashMap<>());
    }
  }

  private double myPow(double x, int n, Map<Integer, Double> visited) {
    if (n == 0) {
      return 1;
    } else if (visited.containsKey(n)) {
      return visited.get(n);
    } else {
      double result = myPow(x, n / 2, visited) * myPow(x, n / 2, visited) * (n % 2 == 0 ? 1 : x);
      visited.put(n, result);
      return result;
    }
  }
}
