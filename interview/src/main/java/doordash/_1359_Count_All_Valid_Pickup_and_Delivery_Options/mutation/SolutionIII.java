package doordash._1359_Count_All_Valid_Pickup_and_Delivery_Options.mutation;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionIII implements Solution {
  private static final String P = "P", D = "D";

  public Set<List<String>> countOrders(int n) {
    final BitSet leftCandidate = new BitSet();
    for (int i = 1; i <= n; ++i) {
      leftCandidate.set(i);
    }
    final Set<List<String>> result = new HashSet<>();
    final List<String> curPath = new ArrayList<>();
    countOrders(result, curPath, leftCandidate, new BitSet(), n);
    return result;
  }

  private static void countOrders(final Set<List<String>> result,
                                  final List<String> curPath, final BitSet leftCandidate,
                                  final BitSet rightCandidate, final int n) {
    if (2 * n == curPath.size()) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    final int size = curPath.size();
    // try left;
    for (int i = 1; i <= n; ++i) {
      if (leftCandidate.get(i)) {
        leftCandidate.clear(i);
        rightCandidate.set(i);
        curPath.add(P + i);
        countOrders(result, curPath, leftCandidate, rightCandidate, n);
        curPath.remove(size);
        rightCandidate.clear(i);
        leftCandidate.set(i);
      }
    }

    for (int i = 1; i <= n; ++i) {
      if (rightCandidate.get(i)) {
        rightCandidate.clear(i);
        curPath.add(D + i);
        countOrders(result, curPath, leftCandidate, rightCandidate, n);
        curPath.remove(size);
        rightCandidate.set(i);
      }
    }

  }
}
