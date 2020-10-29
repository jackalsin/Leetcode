package _1601_1650._1629_Slowest_Key;

/**
 * @author jacka
 * @version 1.0 on 9/19/2020
 */
public final class SolutionI implements Solution {
  public char slowestKey(int[] releaseTimes, String keysPressed) {
    int longestTime = releaseTimes[0];
    char maxChr = keysPressed.charAt(0);
    final int n = keysPressed.length();
    for (int i = 1; i < n; ++i) {
      final int cur = releaseTimes[i] - releaseTimes[i - 1];
      if (cur > longestTime) {
        longestTime = cur;
        maxChr = keysPressed.charAt(i);
      } else if (cur == longestTime) {
        final char chr = keysPressed.charAt(i);
        if (chr > maxChr) {
          maxChr = chr;
        }
      }
    }
    return maxChr;
  }
}
