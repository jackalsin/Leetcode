package explore.Number_Complement;

/**
 * @author jacka
 * @version 1.0 on 5/4/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int findComplement(int num) {
    int res = 0;
    for (int times = 0; num != 0; times++) {
      final int d = num & 1;
      res |= (d == 0 ? 1 : 0) << times;
      num >>>= 1;
    }
    return res;
  }
}
