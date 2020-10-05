package airbnb.balancePoint;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SolutionI implements Solution {
  @Override
  public List<Integer> getBalancePoints(int[] weights) {
    // [2, 4, 6, 8, 2]
    // 0 * 2 + 1 * 4 + 2 * 6 + 3 * 8 + 4 * 2
    // -1 * 2 + 0 * 4 + 1 * 6 + 2 * 8 + 3 * 2
    // biggest long = 2 ^ 63 - 1
    // worst case: 2^31 - 1 * (1 + 2+ 3 + ... (2^31 - 1)) -> it's going to overflow even using long
    final long sum = getSum(weights);
    final BigInteger sumBigInteger = BigInteger.valueOf(sum),
        moment = getWeightSum(weights);
    final List<Integer> result = new ArrayList<>();
    if (sum == 0L) {
      for (int i = 0; i < weights.length; i++) {
        result.add(i);
      }
      return result;
    }
    if (!moment.mod(BigInteger.valueOf(sum)).equals(BigInteger.ZERO)) {
      return result;
    }
    result.add(moment.divide(sumBigInteger).intValue());
    return result;
  }

  private static BigInteger getWeightSum(final int[] weights) {
    BigInteger result = new BigInteger("0");
    for (int i = 0; i < weights.length; i++) {
      final BigInteger cur = new BigInteger(String.valueOf(weights[i]))
          .multiply(new BigInteger(String.valueOf(i)));
      result = result.add(cur);
    }
    return result;
  }

  private static long getSum(final int[] weights) {
    return Arrays.stream(weights).mapToLong(i -> (long) i).sum();
  }
}
