package facebook._157_Read_N_Characters_Given_Read;

import _0151_0200._157_Read_N_Characters_Given_Read4.Reader4;

public class Solution extends Reader4 {
  public Solution(String s) {
    super(s);
  }

  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return The number of characters read
   */
  public int read(char[] buf, int n) {
    final char[] tempBuf = new char[4];
    int count = 0;
    while (n > count) {
      final int c = read4(tempBuf);
      if (c == 0) {
        break;
      }
      final int maxCount = Math.min(c, n - count);
      System.arraycopy(tempBuf, 0, buf, count, maxCount);
      count += maxCount;
    }
    return count;
  }

}
