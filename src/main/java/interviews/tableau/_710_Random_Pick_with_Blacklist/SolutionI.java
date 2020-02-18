package interviews.tableau._710_Random_Pick_with_Blacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 2/17/2020
 */
public final class SolutionI implements Solution {
  private final Random rand = new Random();
  private final int N;
  private final Map<Integer, Integer> map = new HashMap<>();

  public SolutionI(int N, int[] blacklist) {
    for (final int n : blacklist) {
      map.put(n, -1);
    }
    this.N = N - blacklist.length;
    N--;
    for (int i : blacklist) {
      if (i < this.N) {
        while (map.containsKey(N)) {
          N--;
        }
        map.put(i, N--);
      }
    }
//    System.out.println(map);
  }

  public int pick() {
    final int picked = rand.nextInt(N);
    return map.getOrDefault(picked, picked);
  }
}
