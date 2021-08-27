package airbnb._277_Find_the_Celebrity;

/**
 * @author jacka
 * @version 1.0 on 8/26/2021
 */
public final class SolutionII extends Solution {
  public int findCelebrity(int n) {
    if (n <= 0) return -1;
    int candidate = 0;
    for (int i = 1; i < n; ++i) {
      if (knows(candidate, i)) candidate = i;
    }
    for (int i = 0; i < n; ++i) {
      if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;
    }
    return candidate;
  }
}
