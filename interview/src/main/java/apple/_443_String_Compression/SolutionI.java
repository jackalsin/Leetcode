package apple._443_String_Compression;

/**
 * @author jacka
 * @version 1.0 on 2/23/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int compress(char[] chars) {
    if (chars == null || chars.length == 0) {
      return 0;
    }
    final int n = chars.length;
    int cur = 0;
    for (int start = 0, end = 0; end < chars.length; end++) {
      start = end;
      final char chr = chars[start];
      while (end + 1 < n && chars[end + 1] == chr) {
        end++;
      }
      final int count = end - start + 1;
      chars[cur++] = chr;
      if (count != 1) {
        final String countStr = String.valueOf(count);
        for (int i = 0; i < countStr.length(); i++, cur++) {
          chars[cur] = countStr.charAt(i);
        }
      }
    }
    return cur;
  }
}
