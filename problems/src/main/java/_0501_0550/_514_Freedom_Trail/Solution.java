package _0501_0550._514_Freedom_Trail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

  public int findRotateSteps(String ring, String key) {
    final Map<Character, List<Integer>> charToIndex = new HashMap<>();
    final char[] rings = ring.toCharArray();
    for (int i = 0; i < rings.length; i++) {
      List<Integer> index = charToIndex.getOrDefault(rings[i], new ArrayList<>());
      index.add(i);
      charToIndex.put(rings[i], index);
    }

    return dfs(charToIndex, key, new int[ring.length()][key.length()], ring.length(), 0, 0);

  }

  private int dfs(final Map<Character, List<Integer>> charToIndex, final String key, final int[][] cache, int ringLen,
                  int curKeyIndex, int ringIndex) {
    if (curKeyIndex >= key.length()) {
      return 0; // may be 1 ??
    }
    if (cache[ringIndex][curKeyIndex] > 0) {
//      System.out.println("Hit " + ringIndex + " " + curKeyIndex);
      return cache[ringIndex][curKeyIndex];
    }
    final char candidateChar = key.charAt(curKeyIndex);
    final List<Integer> candidateIndex = charToIndex.get(candidateChar);
    assert candidateIndex != null;
    int minDistance = Integer.MAX_VALUE;
    for (int curCharIndexInRing : candidateIndex) {
      int curDistance = getDistance(curCharIndexInRing, ringIndex, ringLen);
      curDistance++; // push the button
      curDistance += dfs(charToIndex, key, cache, ringLen, curKeyIndex + 1, curCharIndexInRing);
      minDistance = Math.min(minDistance, curDistance);
    }
    cache[ringIndex][curKeyIndex] = minDistance;
    return minDistance;
  }

  private static int getDistance(int curCharIndexInRing, int ringIndex, int ringLen) {
    int clockwise = ringIndex - curCharIndexInRing;
    if (clockwise < 0) {
      clockwise += ringLen;
    }
    int antiClockwise = curCharIndexInRing - ringIndex;
    if (antiClockwise < 0) {
      antiClockwise += ringLen;
    }
    return Math.min(clockwise, antiClockwise);
  }
}
