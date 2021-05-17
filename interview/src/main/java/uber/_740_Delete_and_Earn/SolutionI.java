package uber._740_Delete_and_Earn;

/**
 * @author jacka
 * @version 1.0 on 5/16/2021
 */
public final class SolutionI implements Solution {
  private static final int MAX = 10_000;

  public int deleteAndEarn(int[] nums) {
    final int[] counts = new int[MAX + 1];
    for (int n : nums) counts[n]++;
    int take = 0, skip = 0;

    for (int i = 1; i <= MAX; ++i) {
      final int nextTake = counts[i] * i + skip,
          nextSkip = Math.max(skip, take);
      take = nextTake;
      skip = nextSkip;
    }
    return Math.max(take, skip);
  }
}
