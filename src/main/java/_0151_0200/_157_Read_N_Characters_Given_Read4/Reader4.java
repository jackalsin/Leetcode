package _0151_0200._157_Read_N_Characters_Given_Read4;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/19/2017.
 */
public class Reader4 {
  private final String s;

  public Reader4(String s) {
    this.s = s;
  }

  private int point = 0;
  private boolean eof = false;
  public int read4(char[] buf) {
    if (buf.length > point + 4) {
      point += 4;
      return 4;
    } else {
      if (eof) {
        return 0;
      } else {
        eof = true;
        int res = buf.length - point;
        point = buf.length - 1;
        return res;
      }
    }
  }
}
