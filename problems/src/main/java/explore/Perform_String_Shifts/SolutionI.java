package explore.Perform_String_Shifts;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String stringShift(String s, int[][] shift) {
    int leftShift = 0;
    for (final int[] d : shift) {
      leftShift += (d[0] == 0 ? 1 : -1) * d[1];
    }
    final StringBuilder sb = new StringBuilder();
    leftShift = ((leftShift % s.length()) + s.length()) % s.length();
    for (int i = leftShift; sb.length() < s.length(); i = (i + 1) % s.length()) {
      sb.append(s.charAt(i));
    }
    return sb.toString();
  }
}
