package _0851_0900._880_Decoded_String_at_Index;

/**
 * @author jacka
 * @version 1.0 on 9/14/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String decodeAtIndex(String s, int K) {
    long len = 0;
    int i = 0;
    final char[] chars = s.toCharArray();
    for (; len < K; ++i) {
      if (Character.isDigit(chars[i])) {
        len *= (chars[i] - '0');
      } else {
        len += 1;
      }
    }
    --i; // 出for loop的时候，会自动 + 1
    for (; ; --i) {
      final char chr = chars[i];
      if (Character.isDigit(chr)) {
        len /= chr - '0';
        K %= len;
      } else {
        if (K % len == 0) {
          return String.valueOf(chr);
        }
        --len; // move single;
      }
    }
  }
}
