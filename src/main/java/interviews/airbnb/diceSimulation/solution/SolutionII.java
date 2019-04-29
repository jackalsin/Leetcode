package interviews.airbnb.diceSimulation.solution;

import interviews.airbnb.diceSimulation.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The solve rate should be around 7.14%
 */
public final class SolutionII implements Solution {
  private static final int N = 6, BOXES = 9;
  private final double[] sumProbability = getSumProbability();
  private int state; // 1 is closed, 0 is open
  private final double[][] cache;
  private final Dice dice = new Dice();
  /**
   * state to (sum to combination)
   */
//  private final Map<Integer, Map<Integer, List<Integer>>> combinations = new HashMap<>();
  private final List[][] combinations;

  public SolutionII() {
    // generate cache
    for (int i = 2; i <= 12; i++) {
      sumToPermutation.put(i, getPermutation(i));
    }

    sumToPermutation.forEach((sum, p) -> System.out.println("sum = " + sum + ", list = " + p));
    state = getInitState();
    cache = new double[state + 1][N + N + 1];
    combinations = new List[state + 1][N + N + 1];
    Arrays.stream(cache).forEach(x -> Arrays.fill(x, -1d));
    for (int sum = 2; sum <= 12; sum++) {
      System.out.println(sum);
      dfs(state, sum);
    }
  }

  private static int getInitState() {
    int res = 0;
    for (int i = 1; i <= BOXES; i++) {
      res += (1 << (i - 1));
    }
    return res;
  }

  private static double[] getSumProbability() {
    final double[] result = new double[N + N + 1];
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        result[i + j] += 1d / (N * N);
      }
    }
    return result;
  }

  @Override
  public boolean solve() {
    int state = this.state;
    while (state != 0) {
      final int sum = dice.roll(2);
      final List<Integer> curSolution = combinations[state][sum];
//      System.out.println(curSolution); // print solution
      if (curSolution == null) return false; // 没有solution
      state = getNextState(state, curSolution);
    }
    return true; // solve
  }

  /**
   * Generate cache
   *
   * @param state
   * @param sum
   * @return
   */
  private double dfs(final int state, final int sum) {
    if (cache[state][sum] != -1) return cache[state][sum];
    if (state == 0d) {
      cache[state][sum] = 1d;
      return 1d;
    }
    final List<List<Integer>> curSumPermutations = getPermutation(state, sum);
    if (curSumPermutations.isEmpty()) {
      cache[state][sum] = 0d;
      return 0d;
    }
    double bestProb = 0d;
    for (final List<Integer> p : curSumPermutations) {
      final int nextState = getNextState(state, p);
      double probability = 0d;
      for (int nextSum = 2; nextSum <= 12; nextSum++) {
        probability += sumProbability[nextSum] * dfs(nextState, nextSum);
      }
      if (probability > bestProb) {
        bestProb = probability;
        combinations[state][sum] = p;
      }
    } // end for loop curPermutations
    cache[state][sum] = bestProb;
    return bestProb;
  }

  /**
   * @param state current state
   * @param p     the permutation
   * @return
   */
  static int getNextState(final int state, final List<Integer> p) {
    int res = state;
    for (int c : p) {
      res -= (1 << (c - 1));
    }
    return res;
  }

  /**
   * @param state indicates the closed or open box
   * @param sum   target sum
   * @return
   */
  private List<List<Integer>> getPermutation(final int state, final int sum) {
    final List<List<Integer>> result = new ArrayList<>();
    if (sum < 2) {
      return result;
    }
//    final Set<Integer> candidates = new HashSet<>(stateToList(state));
//    final List<List<Integer>> possible = sumToPermutation.get(sum);
//    for (final List<Integer> cand : possible) {
//      if (candidates.containsAll(cand)) {
//        result.add(cand);
//      }
//    }

    final List<Integer> candidates = stateToList(state);
    getPermutation(result, candidates, new ArrayList<>(), sum, 0);
    return result;
  }

  private static void getPermutation(final List<List<Integer>> result, final List<Integer> candidates,
                                     final List<Integer> curPath, final int sum, final int start) {
    if (sum < 0) {
      return;
    }
    if (sum == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    if (start == candidates.size()) {
      return;
    }
    for (int i = start; i < candidates.size(); i++) {
      final int cand = candidates.get(i);
      if (cand > sum) return;
      curPath.add(cand);
      getPermutation(result, candidates, curPath, sum - cand, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }

  static List<Integer> stateToList(final int state) {
    final List<Integer> result = new ArrayList<>();
    for (int candidate = 1, i = 1; i <= state; i <<= 1, candidate++) {
      if ((state & i) != 0) {
        result.add(candidate);
      }
    }
    return result;
  }

  // ------ permutation generation
  private final Map<Integer, List<List<Integer>>> sumToPermutation = new HashMap<>();


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
    if (start == 9 + 1) {
      return;
    }
    for (int i = start; i <= 9; i++) {
      curPath.add(i);
      getPermutation(result, curPath, sum - i, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }
}
