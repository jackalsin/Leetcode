package facebook._043_Multiply_Strings;

public class Solution {
  public String multiply(String num1, String num2) {
    final int m = num1.length(), n = num2.length();
    final int[] res = new int[m + n];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        final int digitI = num1.charAt(i) - '0', digitJ = num2.charAt(j) - '0';
        final int p1 = i + j, p2 = j + i + 1;
        int sum = res[p2] + digitI * digitJ;
        res[p2] = sum % 10;
        res[p1] += sum / 10;
      }
    }

    final StringBuilder sb = new StringBuilder();
    boolean leadingZero = true;
    for (int i = 0; i < res.length; i++) {
      if (res[i] != 0) {
        leadingZero = false;
      }
      if (!leadingZero) {
        sb.append(res[i]);
      }
    }
    // there is a chance to be zero
    return sb.length() == 0 ? "0" : sb.toString();
  }
}
