package interviews.uber.blacklistSampling;

import java.util.*;
import java.util.stream.Collectors;

/**
 * http://www.1point3acres.com/bbs/thread-305867-1-1.html
 *
 * @author jacka
 * @version 1.0 on 2/7/2018.
 */
public class Solution {

  private final Set<Integer> blackList = new HashSet<>();
  private final Random random = new Random();

  public Solution(final int[] blackList) {
    this.blackList.addAll(Arrays.stream(blackList).boxed().collect(Collectors.toList()));
  }

  public int getRandom(final List<Integer> candidates) {
    if (candidates == null || candidates.size() == 0) {
      return -1;
    }
    int result = -1;
    int i = 0, bCount = 0;
    for (; i < candidates.size(); i++) {
      result = candidates.get(i);
      if (!blackList.contains(result)) break;
      bCount++;
    }
    if (result == -1) throw new IllegalStateException("All the candidates in black list");
    for (i++; i < candidates.size(); i++) {
      if (blackList.contains(candidates.get(i))) {
        bCount++;
        continue;
      }
      final int seed = random.nextInt(i + 1 - bCount);
      if (seed < 1) {
        result = candidates.get(i);
      }
    }
    return result;
  }
}
