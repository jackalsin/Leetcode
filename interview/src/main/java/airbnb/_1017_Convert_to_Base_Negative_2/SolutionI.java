package airbnb._1017_Convert_to_Base_Negative_2;

/**
 * @author jacka
 * @version 1.0 on 9/7/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String baseNeg2(int N) {
    final StringBuilder sb = new StringBuilder();

    while (N != 0) {
      sb.append(N & 1);
      N = -(N >> 1);
    }
    return sb.length() == 0 ? "0" : sb.reverse().toString();
  }
}
