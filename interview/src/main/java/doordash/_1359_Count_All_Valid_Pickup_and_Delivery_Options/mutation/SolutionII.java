package doordash._1359_Count_All_Valid_Pickup_and_Delivery_Options.mutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionII implements Solution {
  private static final String P = "P", D = "D";

  public Set<List<String>> countOrders(int n) {
    final Set<List<String>> result = new HashSet<>();
    final List<String> curPath = new ArrayList<>();
    countOrder(result, curPath, n, new HashSet<>(), new HashSet<>());
    return result;
  }

  private static void countOrder(final Set<List<String>> result, final List<String> curPath,
                                 final int n, final Set<Integer> leftUsed, final Set<Integer> rightUsed) {
    if (curPath.size() == 2 * n) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    for (int i = 1; i <= n; ++i) {
      if (leftUsed.add(i)) {
        final String toAdd = P + i;
        curPath.add(toAdd);
        countOrder(result, curPath, n, leftUsed, rightUsed);
        leftUsed.remove(i);
        curPath.remove(curPath.size() - 1);
      }
    } // end of for
    for (int i = 1; i <= n; ++i) {
      if (leftUsed.contains(i) && rightUsed.add(i)) {
        final String toAdd = D + i;
        curPath.add(toAdd);
        countOrder(result, curPath, n, leftUsed, rightUsed);
        rightUsed.remove(i);
        curPath.remove(curPath.size() - 1);
      }
    }
  }
}
