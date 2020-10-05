package _0751_0800._752_Open_the_Lock;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


/**
 * 43 / 43 test cases passed.
 * Status: Accepted
 * Runtime: 71 ms
 */
public final class BfsSolution implements Solution {
  private static final int[] DIRS = {1, 10, 100, 1000};

  public int openLock(String[] deadends, String t) {
    final Queue<Integer> q = new ArrayDeque<>();
//    final Set<Integer> dead = Arrays.stream(deadends).map(Integer::parseInt).collect(Collectors.toSet()), visited = new HashSet<>();
    final Set<Integer> dead = new HashSet<>(), visited = new HashSet<>();
    for (String d : deadends) {
      dead.add(Integer.parseInt(d));
    }
    final int target = Integer.parseInt(t);
    if (dead.contains(target) || dead.contains(0)) return -1;
    if (target == 0) {
      return 0;
    }
    q.add(0);
    visited.add(0);
    int level = 0; // 0000
    while (!q.isEmpty()) {
      final int size = q.size();

      for (int i = 0; i < size; i++) {
        final int toRemove = q.remove();
        for (final int dir : DIRS) {
          final int nextPos = rotate(toRemove, dir), nextNeg = rotate(toRemove, -dir);
          if (target == nextPos || target == nextNeg) {
            return level + 1;
          }
          if (!dead.contains(nextPos) && !visited.contains(nextPos)) {
            visited.add(nextPos);
            q.add(nextPos);
          }
          if (!dead.contains(nextNeg) && !visited.contains(nextNeg)) {
            visited.add(nextNeg);
            q.add(nextNeg);
          }
        }
      } // end of for
      level++;
    }

    return -1;
  }

  static int rotate(final int base, final int diff) {
    int diffCopy = Math.abs(diff), left = base, right = 0, exp = 1;
    while (diffCopy != 1) {
      diffCopy /= 10;
      right += left % 10 * exp;
      left /= 10;
      exp *= 10;
    }

    if (left % 10 == 9 && diff > 0) {
      return left / 10 * 10 * exp + right;
    } else if (left % 10 == 0 && diff < 0) {
      return (left / 10 * 10 + 9) * exp + right;
    } else {
      return base + diff;
    }
  }
}
