package _0151_0200._157_Read_N_Characters_Given_Read4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 7/19/2017.
 */
public abstract class Reader4 {
  private final Queue<Character> s = new ArrayDeque<>();

  public Reader4(String s) {
    for (char chr : s.toCharArray()) {
      this.s.add(chr);
    }
  }

  public int read4(char[] buf) {
    final int res = Math.min(s.size(), 4);
    for (int i = 0; i < res && !s.isEmpty(); i++) {
      buf[i] = s.remove();
    }
    return res;
  }
}
