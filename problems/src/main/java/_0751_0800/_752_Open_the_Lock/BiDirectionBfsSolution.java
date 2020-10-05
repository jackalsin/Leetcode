package _0751_0800._752_Open_the_Lock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 43 / 43 test cases passed.
 * Status: Accepted
 * Runtime: 71 ms
 */
public final class BiDirectionBfsSolution implements Solution {
  @Override
  public int openLock(String[] deadends, String target) {
    Set<String> begin = new HashSet<>(), end = new HashSet<>(), deads = new HashSet<>(Arrays.asList(deadends));
    begin.add("0000");
    end.add(target);
    int level = 0;

    while (!begin.isEmpty() && !end.isEmpty()) {
      final Set<String> next = new HashSet<>();
      for (String cur : begin) {
        if (end.contains(cur)) return level;
        if (deads.contains(cur)) continue;
        for (int i = 0; i < 4; ++i) {

          final String next1 = cur.substring(0, i) + (cur.charAt(i) == '9' ? '0' :
              (char) (cur.charAt(i) + 1)) + cur.substring(i + 1);
          final String next2 = cur.substring(0, i) + (cur.charAt(i) == '0' ? '9' :
              (char) (cur.charAt(i) - 1)) + cur.substring(i + 1);
          if (!deads.contains(next1)) {
            next.add(next1);
          }
          if (!deads.contains(next2)) {
            next.add(next2);
          }
        }
      }
      level++;
      begin = end;
      end = next;
    }

    return -1;
  }
}
