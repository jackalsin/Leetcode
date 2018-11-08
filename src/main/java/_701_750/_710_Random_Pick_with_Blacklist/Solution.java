package _701_750._710_Random_Pick_with_Blacklist;

import java.util.Arrays;
import java.util.Random;

public class Solution {
  private final int blacklist[], N;
  private final Random rand = new Random();

  public Solution(int N, int[] blacklist) {
    this.N = N;
    Arrays.sort(blacklist);
    this.blacklist = blacklist;
  }

  public int pick() {
    final int target = rand.nextInt(N - blacklist.length);
    if (blacklist.length == 0 || blacklist[0] > target) {
      return target;
    }

    // find the first <tt>mid</tt> >= target,
    // result is <code>mid + blacklist[mid] + 1</code>
    int left = 0, right = blacklist.length - 1;

    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (blacklist[mid] >= target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    assert blacklist[left] >= target;
    return left + blacklist[left] + 1;
  }
}
