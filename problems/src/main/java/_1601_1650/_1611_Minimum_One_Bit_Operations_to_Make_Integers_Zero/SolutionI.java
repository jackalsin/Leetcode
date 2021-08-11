package _1601_1650._1611_Minimum_One_Bit_Operations_to_Make_Integers_Zero;

import java.util.HashMap;
import java.util.Map;

public final class SolutionI implements Solution {
  private static final Map<Integer, Integer> CACHE = new HashMap<>() {{
    put(0, 0);
    put(1, 1);
  }};

  public int minimumOneBitOperations(int n) {
    if (CACHE.containsKey(n)) return CACHE.get(n);
    final int leftBitVal = Integer.highestOneBit(n);
    final int k = Integer.toBinaryString(leftBitVal).length() - 1;
    final int res = twoKToZero(k) - minimumOneBitOperations(n - leftBitVal);
    CACHE.put(n, res);
    return res;
  }

  private static int twoKToZero(final int k) {
    return (1 << (k + 1)) - 1;
  }
}
