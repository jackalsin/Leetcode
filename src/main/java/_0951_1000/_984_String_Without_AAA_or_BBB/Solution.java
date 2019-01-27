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
    for (int i = 0; i < B; i++) {
      sb.append(a).append(b);
    }

    for (int i = 0; i < A - B; i++) {
      if (i * 3 <= sb.length()) {
        sb.insert(i * 3, a);
      } else {
        sb.append(a);
      }
    }
    return sb.toString();
  }

}
