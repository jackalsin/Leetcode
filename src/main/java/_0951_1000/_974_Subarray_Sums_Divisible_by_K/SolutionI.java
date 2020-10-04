package _0951_1000._974_Subarray_Sums_Divisible_by_K;

/**
 * @author zhixi
 * @version 1.0 on 10/4/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int subarraysDivByK(int[] A, int K) {
    int res = 0, sum = 0;
    int[] count = new int[K + 1];
    count[0] = 1;
    for (int a : A) {
      sum = ((sum + a + K) % K + K) % K;
      res += count[sum];
      count[sum]++;
    }
    return res;
  }

}
