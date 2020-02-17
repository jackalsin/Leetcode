package interviews.tableau._338_Counting_Bits;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] countBits(int num) {
    final int[] res = new int[num + 1];
    for (int i = 1, bound = 1; i <= num; ++i) {
      if (bound == i) {
        res[i] = 1;
        bound <<= 1;
      } else {
        res[i] = res[i - bound / 2] + 1;
      }
    }
    return res;
  }
}
