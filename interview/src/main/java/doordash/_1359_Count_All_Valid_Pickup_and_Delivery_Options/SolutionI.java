package doordash._1359_Count_All_Valid_Pickup_and_Delivery_Options;

/**
 * @author jacka
 * @version 1.0 on 7/8/2021
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int countOrders(int n) {
    assert n >= 0;
    int res = 1;
    for (int i = 2; i <= n; ++i) {
      res = (int) ((res * (2L * i - 1) * i) % MOD);
    }
    return res;
  }
}
