package google._158_Read_N_Characters_Given_Read4_II_Call_multiple_times;

import definition._157_Read_N_Characters_Given_Read4.Reader4;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 4/14/2020
 */
public final class SolutionI extends Reader4 implements Solution {
  public SolutionI(String s) {
    super(s);
  }

  private static final int N = 4;
  private final Queue<Character> q = new ArrayDeque<>();

  public int read(char[] buf, int n) {
    int res = 0;
    for (int i = 0; i < n; ++i) {
      if (q.isEmpty()) {
        final char[] buffer = new char[N];
        final int read = super.read4(buffer);
        if (read == 0) {
          break; // break i loop
        }
        for (int j = 0; j < read; ++j) {
          q.add(buffer[j]);
        }
      }
      buf[i] = q.remove();
      res++;
    }
    return res;
  }
}
