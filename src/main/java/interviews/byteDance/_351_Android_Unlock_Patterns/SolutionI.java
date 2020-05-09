package interviews.byteDance._351_Android_Unlock_Patterns;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 5/8/2020
 */
public final class SolutionI implements Solution {
  private static final Set<Integer> SIDES = Set.of(
      2, 4, 6, 8
  ), CORNERS = Set.of(
      1, 3, 7, 9
  );

  public int numberOfPatterns(int m, int n) {
    final Set<Integer> visited = new HashSet<>();
    visited.add(1);
    final int one = count(m, n, 1, visited, 1);
    visited.remove(1);
    visited.add(2);
    final int two = count(m, n, 2, visited, 1);
    visited.remove(2);
    visited.add(5);
    final int five = count(m, n, 5, visited, 1);
    visited.remove(5);
//    System.out.println(one);
//    System.out.println(two);
//    System.out.println(five);
    return one * 4 + two * 4 + five;
  }

  private static int count(final int m, final int n, final int cur, final Set<Integer> visited, final int len) {
    if (len > n) {
      return 0;
    }
    int count = 0;
    if (len >= m) {
      count++;
    }
    for (int next = 1; next <= 9; ++next) {
      if (SIDES.contains(cur)) {
        if (visited.contains(next) || (cur + next == 10 && !visited.contains(5))) continue;
        visited.add(next);
        count += count(m, n, next, visited, len + 1);
        visited.remove(next);
      } else if (CORNERS.contains(cur)) {
        if (visited.contains(next) || (CORNERS.contains(next) && !visited.contains((cur + next) / 2))) continue;
        visited.add(next);
        count += count(m, n, next, visited, len + 1);
        visited.remove(next);
      } else {
        assert cur == 5;
        if (visited.contains(next)) continue;
        visited.add(next);
        count += count(m, n, next, visited, len + 1);
        visited.remove(next);
      }
    }
    return count;
  }
  /* 1, 2, 3
   * 4, 5, 6,
   * 7, 8, 9
   */
}
