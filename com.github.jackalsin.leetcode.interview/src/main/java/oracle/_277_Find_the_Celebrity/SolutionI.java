package oracle._277_Find_the_Celebrity;

import definition._277_Find_the_Celebrity.Relation;

/**
 * @author jacka
 * @version 1.0 on 12/1/2019
 */
public final class SolutionI extends Relation {
  public int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; ++i) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }

    for (int i = 0; i < n; ++i) {
      if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
        return -1;
      }
    }
    return candidate;
  }
}
