package _1051_1100._1079_Letter_Tile_Possibilities;

/**
 * @author zhixi
 * @version 1.0 on 11/29/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int numTilePossibilities(String tiles) {
    final int[] count = new int[26];
    for (final char chr : tiles.toCharArray()) {
      count[chr - 'A']++;
    }
    return dfs(count);
  }

  private static int dfs(final int[] count) {
    int sum = 0;
    for (int i = 0; i < 26; ++i) {
      if (count[i] == 0) continue;
      sum++;
      count[i]--;
      sum += dfs(count);
      count[i]++;
    }
    return sum;
  }
}
