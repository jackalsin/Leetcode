package interviews.linkedin._277_Find_the_Celebrity;

import _251_300._277_Find_the_Celebrity.Relation;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionII extends Relation implements Solution {
  public int findCelebrity(int n) {
    int celebrity = 0;
    for (int i = 1; i < n; i++) {
      if (knows(celebrity, i)) {
        celebrity = i;
      }
    }

    for (int i = 0; i < n; i++) {
      if (i != celebrity) {
        if (knows(celebrity, i) || !knows(i, celebrity)) {
          return -1;
        }
      }
    }
    return celebrity;
  }
}
