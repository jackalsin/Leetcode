package hulu._415_Add_Strings;

/**
 * @author jacka
 * @version 1.0 on 12/17/2019
 */
public final class DoubleSolution implements Solution {
  @Override
  public String addStrings(String num1, String num2) {
    if (num1 == null) {
      throw new NullPointerException();
    }
    if (num2 == null) {
      throw new NullPointerException();
    }
    final int point1 = num1.indexOf("."),
        point2 = num2.indexOf(".");
    final String[] items1 = num1.split("\\."),
        items2 = num2.split("\\.");
    if (point1 == -1 && point2 == -1) {
      return add(num1, num2, 0);
    } else if (point1 == -1) {
      return add(items1[0], items2[0], 0) + "." + items2[1];
    } else if (point2 == -1) {
      return add(items1[0], items2[0], 0) + "." + items1[1];
    } else {
      String floatPart = add(items1[1], items2[1], 0);
      int carry = 0;
      if (floatPart.length() != Math.max(items1[1].length(), items2[1].length())) {
        // have a carry
        carry++;
        floatPart = floatPart.substring(1);
      }
      return prune(add(items1[0], items2[0], carry) + "." + floatPart);
    }
  }

  private static String add(final String num1, final String num2, int carry) {
    final int m = num1.length(), n = num2.length();
    final char[] result = new char[Math.max(n, m) + 1];
    for (int i = m - 1, j = n - 1, k = result.length - 1; k >= 0; --k, --i, --j) {
      final int a = i < 0 ? 0 : num1.charAt(i) - '0',
          b = i < 0 ? 0 : num2.charAt(j) - '0', sum = a + b + carry;
      carry = sum / 10;
      result[k] = (char) (sum % 10 + '0');
    }
    final String candidate = String.valueOf(result);
    return candidate.startsWith("0") ? candidate.substring(1) : candidate;
  }

  private static String prune(final String num) {
    final int pointIndex = num.indexOf(".");
    final StringBuilder sb = new StringBuilder(num);
    if (pointIndex != -1) {
      int right = num.length() - 1;
      while (right >= 0 && num.charAt(right) == '0') {
        right--;
      }
      sb.setLength(right + 1);
    }
    if (sb.charAt(sb.length() - 1) == '.') {
      sb.setLength(sb.length() - 1);
    }
    return sb.toString();
  }
}
