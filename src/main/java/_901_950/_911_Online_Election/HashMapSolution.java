package _901_950._911_Online_Election;

import java.util.HashMap;
import java.util.Map;

/**
 * 97 / 97 test cases passed.
 * Status: Accepted
 * Runtime: 278 ms
 */
public final class HashMapSolution implements TopVotedCandidate {
  private final Map<Integer, Integer> timeToLead = new HashMap<>();
  private final int[] times;

  /**
   * Time Complexity: O(N)
   *
   * @param persons
   * @param times
   */
  public HashMapSolution(int[] persons, int[] times) {
    final int n = persons.length;
    this.times = times;
    final Map<Integer, Integer> counts = new HashMap<>();
    int lead = -1;
    for (int i = 0; i < n; ++i) {
      final int p = persons[i], t = times[i];
      counts.put(p, counts.getOrDefault(p, 0) + 1);
      if (lead == -1 || counts.get(p) >= counts.get(lead)) lead = p;
      timeToLead.put(t, lead);
    }
  }

  /**
   * Time Complexity: O(log N)
   *
   * @param t
   * @return
   */
  public int q(int t) {
    final int normalizedT = lessOrEquals(times, t);
    return timeToLead.get(times[normalizedT]);
  }

  private static int lessOrEquals(final int[] times, final int target) {
    int left = 0, right = times.length - 1;
    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (times[mid] <= target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }

    assert (times[left] >= times[0]);

    return left;
  }
}
