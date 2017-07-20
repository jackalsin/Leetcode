package _151_200._157_Read_N_Characters_Given_Read4;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/19/2017.
 */
public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Maximum number of characters to read
   * @return    The number of characters read
   */
  public int read(char[] buf, int n) {
    int cur = 0;
    for (; cur < n && cur < buf.length;) {
      int actualBytes = read4(buf);
      if(actualBytes == 0) break;
      cur += actualBytes;
    }
    return cur;
  }
}
