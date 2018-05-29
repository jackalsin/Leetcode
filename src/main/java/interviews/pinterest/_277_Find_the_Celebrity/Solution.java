package interviews.pinterest._277_Find_the_Celebrity;

import _251_300._277_Find_the_Celebrity.Relation;

public class Solution extends Relation {
  /**
   * 171 / 171 test cases passed.
   * Status: Accepted
   * Runtime: 14 ms
   *
   * @param n
   * @return
   */
  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
        return -1; // not found
      }
    }
    return candidate;
  }
}
