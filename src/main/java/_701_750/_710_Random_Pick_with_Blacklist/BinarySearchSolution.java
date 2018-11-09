package _701_750._710_Random_Pick_with_Blacklist;

import java.util.Arrays;
import java.util.Random;

/**
 * 67 / 67 test cases passed.
 * Status: Accepted
 * Runtime: 156 ms
 */
public final class BinarySearchSolution implements Solution {
  private final int blacklist[], N;
  private final Random rand = new Random();

  public BinarySearchSolution(int N, int[] blacklist) {
    this.N = N;
    Arrays.sort(blacklist);
    this.blacklist = blacklist;
  }

  /**
   * Time complexity: O(log(B))
   * Space complexity: O(1)
   *
   * @return
   */
  public int pick() {
    final int target = rand.nextInt(N - blacklist.length);
    if (blacklist.length == 0) {
      return target;
    }

    // find the last <tt>mid</tt> < target,
    // result is <code>mid + blacklist[mid] + 1</code>
    int left = 0, right = blacklist.length - 1;

    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (blacklist[mid] - mid <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (blacklist[left] - left > target) {
      return target;
    }
    return left + target + 1;
  }
}
