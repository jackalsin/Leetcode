package _0601_0650._649_Dota2_Senate;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author jacka
 * @version 1.0 on 3/8/2020
 */
public final class SolutionI implements Solution {
  private static final String RADIANT = "Radiant", DIRE = "Dire";
  private static final char R = 'R', D = 'D';

  public String predictPartyVictory(String senate) {
    final int n = senate.length();
    final Queue<Integer> rQ = new ArrayDeque<>(),
        dQ = new ArrayDeque<>();
    final char[] chars = senate.toCharArray();
    for (int i = 0; i < n; ++i) {
      if (chars[i] == R) {
        rQ.add(i);
      } else {
        dQ.add(i);
      }
    }
    while (!rQ.isEmpty() && !dQ.isEmpty()) {
      final int rIndex = rQ.remove(), dIndex = dQ.remove();
      if (rIndex < dIndex) {
        rQ.add(rIndex + n);
      } else {
        dQ.add(dIndex + n);
      }
    }

    return rQ.isEmpty() ? DIRE : RADIANT;
  }
}
