package _0151_0200._157_Read_N_Characters_Given_Read4;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/19/2017.
 */
public class Solution extends Reader4 {
  public Solution(String s) {
    super(s);
  }

  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return    The number of characters read
   */
  public int read(char[] buf, int n) {
    int cur = 0;
    char[] temp = new char[4];
    boolean eof = false;
    while (!eof && cur < n) {
      int actual = read4(temp);
      if (actual < 4) {
        eof = true;
      }
      int inc = Math.min(actual, n - cur);
      for (int i = 0; i < inc; i++) {
        buf[cur++] = temp[i];
      }
    }
    return cur;
  }
}
