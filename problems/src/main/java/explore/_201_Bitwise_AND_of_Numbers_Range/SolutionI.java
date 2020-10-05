package explore._201_Bitwise_AND_of_Numbers_Range;

public final class SolutionI implements Solution {
  @Override
  public int rangeBitwiseAnd(int m, int n) {
    int times = 1;
    while (m != n) {
      m >>= 1;
      n >>= 1;
      times <<= 1;
    }
    return times * m;
  }
}
