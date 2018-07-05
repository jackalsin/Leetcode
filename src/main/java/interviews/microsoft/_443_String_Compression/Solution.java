package interviews.microsoft._443_String_Compression;

public class Solution {
  public int compress(char[] chars) {
    int i = 0, count = 1;
    char chr = chars[0];

    for (int j = 1; j < chars.length; j++) {
      if (chr == chars[j]) {
        count++;
      } else {
        chars[i++] = chr;
        if (count > 1) {
          i = appendCount(chars, count, i);
        }
        count = 1;
        chr = chars[j];
      }
    }

    chars[i++] = chr;
    if (count > 1) {
      i = appendCount(chars, count, i);
    }
    return i;
  }

  private static int appendCount(final char[] chars, final int count, int curEnd) {
    final char[] counts = String.valueOf(count).toCharArray();
    for (int c = 0; c < counts.length; c++) {
      chars[curEnd++] = counts[c];
    }
    return curEnd;
  }

}
