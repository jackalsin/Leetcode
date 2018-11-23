package interviews.linkedin._277_Find_the_Celebrity;

import _0251_0300._277_Find_the_Celebrity.Relation;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public final class SolutionIV extends Relation implements Solution { // TODO:
  public int findCelebrity(int n) {
    int cand = 0;
    for (int i = 1; i < n; ++i) {
      if (knows(cand, i)) {
        cand = i;
      }
    }
    for (int i = 0; i < n; ++i) {
      if (i != cand && (knows(cand, i) || !knows(i, cand))) {
        return -1;
      }
    }
    return cand;
  }
}
