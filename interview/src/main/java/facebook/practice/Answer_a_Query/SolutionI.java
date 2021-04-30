package facebook.practice.Answer_a_Query;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author jacka
 * @version 1.0 on 4/30/2021
 */
public final class SolutionI implements Solution {
  @Override
  public int[] answerQueries(List<Query> queries, int N) {
    if (queries == null || queries.isEmpty()) return new int[0];
    final List<Integer> result = new ArrayList<>();
    final TreeSet<Integer> set = new TreeSet<>(); // track true index
    for (final Query q : queries) {
      if (q.type == 1) { // Set
        set.add(q.index);
      } else { // Get
        final Integer candidate = set.ceiling(q.index);
        result.add(candidate == null ? -1 : candidate);
      }
    }
    return result.stream().mapToInt(x -> x).toArray();
  }


}
