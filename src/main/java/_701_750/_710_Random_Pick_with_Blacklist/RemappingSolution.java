package _701_750._710_Random_Pick_with_Blacklist;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class RemappingSolution implements Solution {
  private final Random rand = new Random();
  private final int N;
  private final Map<Integer, Integer> map = new HashMap<>();

  public RemappingSolution(int N, int[] blacklist) {
    for (int i : blacklist) {
      map.put(i, -1);
    }
    this.N = N - blacklist.length;
    N--;
    for (int elem : blacklist) {
      if (elem < this.N) {
        while (map.containsKey(N)) {
          N--;
        }
        map.put(elem, N--);
      }
    }
  }

  public int pick() {
    final int i = rand.nextInt(N);
    return map.getOrDefault(i, i);
  }
}
