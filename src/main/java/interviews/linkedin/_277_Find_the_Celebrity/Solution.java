package interviews.linkedin._277_Find_the_Celebrity;

import _251_300._277_Find_the_Celebrity.Relation;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class Solution extends Relation {
  public int findCelebrity(int n) {
    int celebrity = 0;
    for (int i = 1; i < n; ++i) {
      if (i == celebrity) {
        continue;
      }
      if (!knows(celebrity, i)) {
        celebrity = i;
      }
    }

    for (int i = 0; i < n; ++i) {
      if (celebrity == i) {
        continue;
      }
      if (!knows(i, celebrity) || knows(celebrity, i)) {
        return -1;
      }
    }
    return celebrity;
  }
}
