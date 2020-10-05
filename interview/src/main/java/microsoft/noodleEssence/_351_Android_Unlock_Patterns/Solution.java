package microsoft.noodleEssence._351_Android_Unlock_Patterns;

import java.util.HashSet;
import java.util.Set;

public class Solution {

  private static final Set<Integer> CORNER = new HashSet<>() {
    {
      add(1);
      add(3);
      add(7);
      add(9);
    }
  };
  private static final Set<Integer> SIDE = new HashSet<>() {{
    add(2);
    add(4);
    add(6);
    add(8);
  }};

  public int numberOfPatterns(int m, int n) {
    final Set<Integer> used = new HashSet<>();
    used.add(1);
    final int oneCounts = dfs(1, m, n, used);
    used.remove(1);
    used.add(2);
    final int twoCounts = dfs(2, m, n, used);
    used.remove(2);
    used.add(5);
    final int fiveCounts = dfs(5, m, n, used);
//    System.out.println(oneCounts);
//    System.out.println(twoCounts);
//    System.out.println(fiveCounts);
    return 4 * (oneCounts + twoCounts) + fiveCounts;
  }

  private int dfs(final int start, final int m, final int n, final Set<Integer> used) {
    if (used.size() > n) {
      return 0;
    }
    int res = 0;
    if (used.size() >= m) {
      res++;
    }
    if (CORNER.contains(start)) {
      for (int i = 1; i <= 9; i++) {
        if ((CORNER.contains(i) && i != start && !used.contains((i + start) / 2)) || used.contains(i)) continue;
        used.add(i);
        res += dfs(i, m, n, used);
        used.remove(i);
      }
    } else if (start == 5) {
      for (int i = 1; i <= 9; i++) {
        if (used.contains(i)) continue;
        used.add(i);
        res += dfs(i, m, n, used);
        used.remove(i);
      }
    } else {
      for (int i = 1; i <= 9; i++) {
        if ((SIDE.contains(i) && (i + start == 10) && !used.contains(5)) || used.contains(i))
          continue;
        used.add(i);
        res += dfs(i, m, n, used);
        used.remove(i);
      }
    }

    return res;
  }
}
