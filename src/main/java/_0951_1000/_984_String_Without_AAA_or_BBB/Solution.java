package _0951_1000._984_String_Without_AAA_or_BBB;

public class Solution {
  public String strWithout3a3b(int A, int B) {
    if (A < B) {
      return helper(B, 'b', A, 'a');
    }
    return helper(A, 'a', B, 'b');
  }

  private static String helper(int A, final char a, int B, final char b) {
    assert A >= B;
    final StringBuilder sb = new StringBuilder();
    while (A > 0 || B > 0) {
      if (A > 0) {
        sb.append(a);
        A--;
      }
      if (A > B) {
        sb.append(a);
        A--;
      }
      if (B > 0) {
        sb.append(b);
        B--;
      }
    }
    return sb.toString();
  }

}
