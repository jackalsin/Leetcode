package interviews.byteDance._198_House_Robber;

/**
 * @author jacka
 * @version 1.0 on 5/7/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int rob(int[] nums) {
    int rob = 0, noRob = 0;
    for (int n : nums) {
      final int prevRob = rob, prevNoRob = noRob;
      rob = prevNoRob + n;
      noRob = Math.max(prevNoRob, prevRob);
    }
    return Math.max(rob, noRob);
  }
}
