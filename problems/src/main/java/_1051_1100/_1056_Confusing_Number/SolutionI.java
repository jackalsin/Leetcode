package _1051_1100._1056_Confusing_Number;

import java.util.HashMap;
import java.util.Map;

public class SolutionI implements Solution {
  private static final Map<Integer, Integer> MAP = new HashMap<Integer, Integer>() {
    { // 0, 1, 9, 8, 6
      put(0, 0);
      put(1, 1);
      put(6, 9);
      put(9, 6);
      put(8, 8);
    }
  };

  public boolean confusingNumber(int N) {
//    0 <= N <= 10^9
    if (N == 0) {
      return false;
    }
    int original = N, rotate = 0;
    while (N > 0) {
      final int cur = N % 10;
      if (!MAP.containsKey(cur)) {
        return false;
      }
      N /= 10;
      rotate = rotate * 10 + MAP.get(cur);
    }
    return rotate != original;
  }
}
