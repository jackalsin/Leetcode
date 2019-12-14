package interviews.hulu._371_Sum_of_Two_Integers;

/**
 * @author jacka
 * @version 1.0 on 12/14/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int getSum(int a, int b) {
    while (b != 0) {
      final int possibleCarry = a & b;
      a = a ^ b;
      b = possibleCarry << 1;
    }
    return a;
  }
}
