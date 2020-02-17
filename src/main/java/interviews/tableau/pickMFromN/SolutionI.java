package interviews.tableau.pickMFromN;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/16/2020
 */
public final class SolutionI implements Solution {

  public List<Integer> getMFromRange(int start, int end, int picked) {
    final List<Integer> result = new ArrayList<>();
    for (int i = start; i < end; ++i) {
      result.add(i);
    }
    final int n = end - start;
    if (n <= picked) {
      return result;
    }
    Collections.shuffle(result);
    return result.subList(0, picked);
  }
}
