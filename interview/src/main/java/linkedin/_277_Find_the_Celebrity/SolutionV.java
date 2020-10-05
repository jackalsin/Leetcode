package linkedin._277_Find_the_Celebrity;

import definition._277_Find_the_Celebrity.Relation;

/**
 * @author jacka
 * @version 1.0 on 7/19/2019
 */
public final class SolutionV extends Relation {
  public int findCelebrity(int n) {
    // find candidate
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (candidate != i && (knows(candidate, i) || !knows(i, candidate))) {
        return -1;
      }
    }
    return candidate;
  }
}
