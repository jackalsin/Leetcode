package _0401_0450._443_String_Compression;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class Solution {
  public int compress(char[] chars) {
    int count = 0, curEnd = 0;
    char prevChar = 'a';
    for (int i = 0; i < chars.length; i++) {
      if (i == 0) {
        prevChar = chars[i];
        count++;
      } else {
        if (chars[i] == chars[i - 1]) {
          count++;
        } else {
          chars[curEnd++] = prevChar;
          prevChar = chars[i];
          if (count != 1) {
            curEnd = insertCount(chars, count, curEnd);
          }
          count = 1;
        }
      }
    }
    chars[curEnd++] = prevChar;
    if (count != 1) {
      curEnd = insertCount(chars, count, curEnd);
    }
    return curEnd;
  }

  private static int insertCount(final char[] chars, final int count, int curEnd) {
    final char[] counts = String.valueOf(count).toCharArray();
    for (char count1 : counts) {
      chars[curEnd++] = count1;
    }
    return curEnd;
  }
}
