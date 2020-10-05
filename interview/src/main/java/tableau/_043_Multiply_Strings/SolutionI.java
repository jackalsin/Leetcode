package tableau._043_Multiply_Strings;

/**
 * @author jacka
 * @version 1.0 on 2/18/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String multiply(String num1, String num2) {
    if (num1 == null || num2 == null) {
      return "0";
    }
    final int[] result = new int[num1.length() + num2.length()];
    for (int i = num1.length() - 1; i >= 0; --i) {
      final int iVal = num1.charAt(i) - '0';
      for (int j = num2.length() - 1; j >= 0; --j) {
        final int jVal = num2.charAt(j) - '0';
        final int prod = result[i + j + 1] + iVal * jVal;
        result[i + j + 1] = prod % 10;
        result[i + j] += prod / 10;
      }
    }
    final StringBuilder sb = new StringBuilder();
    boolean isLeadingZero = true;
    for (int i : result) {
      if (i == 0 && isLeadingZero) continue;
      isLeadingZero = false;
      sb.append(i);
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }

}
