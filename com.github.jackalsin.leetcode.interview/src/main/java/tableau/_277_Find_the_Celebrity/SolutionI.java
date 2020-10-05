package tableau._277_Find_the_Celebrity;

import _0251_0300._277_Find_the_Celebrity.Relation;

/**
 * @author jacka
 * @version 1.0 on 2/15/2020
 */
public final class SolutionI extends Relation {

  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; ++i) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i == candidate) continue;
      if (!knows(i, candidate) || knows(candidate, i)) return -1;
    }
    return candidate;
  }
}
