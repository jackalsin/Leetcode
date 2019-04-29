package interviews.airbnb.diceSimulation.solution;

import interviews.airbnb.diceSimulation.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SolutionI implements Solution {

  private final Map<Integer, List<List<Integer>>> sumToPermutation = new HashMap<>();
  private static final int MAX_CANDIDATE = 9;
  private final Dice dice = new Dice();
  private final double[] candidateWeights = new double[MAX_CANDIDATE + 1];
  private final int[] sumWeight = {0, 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};

  public SolutionI() {

    for (int i = 2; i <= 12; i++) {
      sumToPermutation.put(i, getPermutation(i));
    }
    sumToPermutation.forEach((key, value) -> System.out.println(String.format("%s = %s", key, value)));
    sumToPermutation.forEach(
        (sum, listValue) -> listValue.forEach(list -> list.forEach(x -> candidateWeights[x] += sumWeight[sum] * (1d / listValue.size()))));
    System.out.println("Candidates Weight = " + Arrays.toString(candidateWeights));
    // sort by priority
    sumToPermutation.forEach((sum, listOfList) -> {
      Collections.sort(listOfList, (l1, l2) -> {
        final List<Double> l1Pq = new ArrayList<>(), l2Pq = new ArrayList<>();
        l1.forEach(e -> l1Pq.add(candidateWeights[e]));
        l2.forEach(e -> l2Pq.add(candidateWeights[e]));
        Collections.sort(l1Pq);
        Collections.sort(l2Pq);
        final int size = Math.min(l1.size(), l2.size());
        for (int i = 0; i < size; i++) {
          final double p1 = l1Pq.get(i), p2 = l2Pq.get(i);
          final int cmp = Double.compare(p1, p2);
          if (cmp != 0) {
            return cmp;
          }
        }
        // if length is different
        return Integer.compare(l1.size(), l2.size()); // 长的在前，几乎毫无影响
      });
    });
  }

  @Override
  public boolean solve() {
    final Set<Integer> boxes = new HashSet<>();
    for (int i = 1; i <= 9; i++) {
      boxes.add(i);
    }
    return solve(boxes);
  }

  public boolean solve(final Set<Integer> closedBoxes) {
    newRound:
    while (!closedBoxes.isEmpty()) {
      final int sum = dice.roll(2);
      final List<List<Integer>> permutations = sumToPermutation.get(sum);
      for (final List<Integer> permutation : permutations) {
        if (closedBoxes.containsAll(permutation)) {
          closedBoxes.removeAll(permutation);
//          System.out.println("Executing: Opening " + permutation);
          continue newRound; // this round done
        }
      }
      return false;
    }
    return true;
  }

  private static List<List<Integer>> getPermutation(final int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    getPermutation(result, new ArrayList<>(), sum, 1);
    return result;
  }

  private static void getPermutation(final List<List<Integer>> result, final List<Integer> curPath, final int sum, final int start) {
    if (sum < 0) {
      return;
    }
    if (sum == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    if (start == MAX_CANDIDATE + 1) {
      return;
    }
    for (int i = start; i <= 9; i++) {
      curPath.add(i);
      getPermutation(result, curPath, sum - i, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
