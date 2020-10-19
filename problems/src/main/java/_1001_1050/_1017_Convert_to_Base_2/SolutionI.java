package _1001_1050._1017_Convert_to_Base_2;

/**
 * @author jacka
 * @version 1.0 on 10/18/2020
 */
public final class SolutionI implements Solution {

  public String baseNeg2(int N) {
    final StringBuilder sb = new StringBuilder();
    while (N != 0) {
      sb.append(N & 1);
      N = -(N >> 1);
    }
    return sb.length() == 0 ? "0" : sb.reverse().toString();
  }
}
