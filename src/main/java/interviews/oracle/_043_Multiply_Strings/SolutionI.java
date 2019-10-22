package interviews.oracle._043_Multiply_Strings;

/**
 * @author jacka
 * @version 1.0 on 10/21/2019
 */
public final class SolutionI implements Solution {
  @Override
  public String multiply(String num1, String num2) {
    final char[] chars1 = num1.toCharArray(), chars2 = num2.toCharArray();
    final int m = chars1.length, n = chars2.length;
    final int[] result = new int[m + n];

    for (int i = chars1.length - 1; i >= 0; --i) {
      final int iVal = chars1[i] - '0';
      for (int j = chars2.length - 1; j >= 0; --j) {
        final int jVal = chars2[j] - '0', sum = result[i + j + 1] + iVal * jVal,
            ones = sum % 10, tens = sum / 10;
        result[i + j + 1] = ones;
        result[i + j] += tens;
      }
    }
    final StringBuilder sb = new StringBuilder();
    boolean skipZero = true;
    for (int i = 0; i < result.length; ++i) {
      if (skipZero) {
        if (result[i] == 0) {
          continue;
        } else {
          skipZero = false;
        }
      }
      sb.append((char) (result[i] + '0'));
    }
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
