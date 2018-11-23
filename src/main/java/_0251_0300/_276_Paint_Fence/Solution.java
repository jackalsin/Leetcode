package _0251_0300._276_Paint_Fence;

/**
 * @author jacka
 * @version 1.0 on 9/2/2017.
 */
public class Solution {
  public int numWays(int n, int k) {
    if (n == 0) return 0;
    else if (n == 1) return k;
    int last2Diff = k * (k - 1);
    int last2Same = k;
    for (int i = 2; i < n; ++i) {
      int prevLast2Diff = last2Diff;
      int prevLast2Same = last2Same;
      last2Diff = prevLast2Diff * (k - 1) + prevLast2Same * (k - 1);
      last2Same = prevLast2Diff;
    }
    return last2Diff + last2Same;
  }
}
