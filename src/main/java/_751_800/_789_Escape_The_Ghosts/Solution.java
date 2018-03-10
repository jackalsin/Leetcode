package _751_800._789_Escape_The_Ghosts;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/8/2018.
 */
public class Solution {

  /**
   * Time Complexity: O(N)
   *
   * <p>Detailed proof:
   * https://leetcode.com/problems/escape-the-ghosts/discuss/116678/Why-interception-in-the-middle-is-not-a-good-idea-for-ghosts.
   *
   * @param ghosts
   * @param target
   * @return
   */
  public boolean escapeGhosts(int[][] ghosts, int[] target) {
    final int srcDistance = distance(new int[] {0, 0}, target);
    for (final int[] g : ghosts) {
      final int gDistance = distance(g, target);
      if (gDistance <= srcDistance) {
        return false;
      }
    }
    return true;
  }

  private int distance(final int[] src, final int[] tgt) {
    return Math.abs(src[0] - tgt[0]) + Math.abs(src[1] - tgt[1]);
  }
}
