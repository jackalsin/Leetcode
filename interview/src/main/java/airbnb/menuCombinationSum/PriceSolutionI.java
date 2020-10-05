package airbnb.menuCombinationSum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class PriceSolutionI implements PriceSolution {
  @Override
  public List<List<Double>> combinationSum(List<Double> candidates, double sum, double delta) {
    if (candidates == null) {
      return new ArrayList<>();
    }
    candidates = new ArrayList<>(candidates);
    final List<List<Double>> result = new ArrayList<>();
    Collections.sort(candidates);
    final int zeroCount = candidates.lastIndexOf(0d) + 1;
    combinationSum(result, candidates.subList(zeroCount, candidates.size()), new ArrayList<>(), sum, delta, 0);
    combinationSum(result, zeroCount);
    return result;
  }

  private static void combinationSum(final List<List<Double>> result, final int zeroCount) {
    final List<List<Double>> resultCopy = new ArrayList<>(result);
    for (final List<Double> resultChild : resultCopy) {
      final LinkedList<Double> toAdd = new LinkedList<>(resultChild);
      for (int i = 0; i < zeroCount; i++) {
        toAdd.addFirst(0d);
        result.add(new ArrayList<>(toAdd));
      }
    }
  }

  private static void combinationSum(final List<List<Double>> result, final List<Double> candidates,
                                     final List<Double> curPath, final double sum, final double delta,
                                     final int startIndex) {
    if (startIndex == candidates.size()) {
      return;
    }
    if (sum <= delta) {
      if (sum < -delta) {
        return;
      }
      result.add(new ArrayList<>(curPath));
    }

    for (int i = startIndex; i < candidates.size(); i++) {
      final double candidate = candidates.get(i);
      if (candidate > sum + delta) return;
      curPath.add(candidates.get(i));
      combinationSum(result, candidates, curPath, sum - candidate, delta, i);
      curPath.remove(curPath.size() - 1);
    }
  }
}
