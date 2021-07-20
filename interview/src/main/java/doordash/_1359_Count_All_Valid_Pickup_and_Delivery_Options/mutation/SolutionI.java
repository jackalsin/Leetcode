package doordash._1359_Count_All_Valid_Pickup_and_Delivery_Options.mutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SolutionI implements Solution {
  private static final String P = "P", D = "D";

  @Override
  public Set<List<String>> countOrders(int n) {
    final List<String> curPath = new ArrayList<>();
    final Set<List<String>> result = new HashSet<>();
    final Set<Integer> left = new HashSet<>();
    countOrder(result, n, curPath, left, new HashSet<>());
    return result;
  }

  private static void countOrder(final Set<List<String>> result, final int n,
                                 final List<String> curPath, final Set<Integer> leftUsed,
                                 final Set<Integer> rightUsed) {
    if (curPath.size() == 2 * n) {
      result.add(new ArrayList<>(curPath));
      return;
    }

    // try add left
    for (int i = 1; i <= n; ++i) {
      if (leftUsed.add(i)) {
        final String toAdd = P + i;
        curPath.add(toAdd);
        countOrder(result, n, curPath, leftUsed, rightUsed);
        curPath.remove(toAdd);
        rightUsed.remove(i);
        leftUsed.remove(i);
      }
    }

    for (int i : leftUsed) {
      if (rightUsed.add(i)) {
        final String toAdd = D + i;
        curPath.add(toAdd);
        countOrder(result, n, curPath, leftUsed, rightUsed);
        curPath.remove(toAdd);
        rightUsed.remove(i);
      }
    }
  }
}
