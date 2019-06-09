package interviews.airbnb.diceSimulation.newSolution;


import interviews.airbnb.diceSimulation.dice.Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UnlimitedBoxSolution implements Solution {

  private static final int N = 6, MAX_BOX = 9, INIT_STATE = getInitState();
  private final double[] sumToProbability = getSumProbability();
  private final double[][] stateToSumToProbability = new double[INIT_STATE + 1][N + N + 1];
  private final Map<Integer, Map<Integer, List<Integer>>> stateToSumToCombinations = new HashMap<>();
  private final Dice dice = new Dice();

  public UnlimitedBoxSolution() {
    Arrays.stream(stateToSumToProbability).forEach(row -> Arrays.fill(row, -1d));
    for (int sum = 2; sum <= 12; sum++) {
      dfs(sum, INIT_STATE);
    }
  }

  @Override
  public boolean solve() {
    int state = INIT_STATE;
    while (state != 0) {
      final int sum = dice.roll(2);
      final List<Integer> curStep = stateToSumToCombinations.getOrDefault(state, new HashMap<>()).get(sum);
      if (curStep == null) return false;
      state = getNextState(state, curStep);
    }
    return true;
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

  private double dfs(final int sum, final int state) {
    if (stateToSumToProbability[state][sum] != -1d) {
      return stateToSumToProbability[state][sum];
    }
    if (state == 0) {
      stateToSumToProbability[state][sum] = 1d;
      return 1d;
    }
    double bestProbability = 0d;
    final List<List<Integer>> combinations = getCombinations(sum, state);
    for (final List<Integer> c : combinations) {
      double curProbability = 0d;
      final int nextState = getNextState(state, c);
      for (int nextSum = 2; nextSum <= N + N; nextSum++) {
        curProbability += sumToProbability[nextSum] * dfs(nextSum, nextState);
      }

      if (bestProbability < curProbability) {
        bestProbability = curProbability;
        stateToSumToCombinations.computeIfAbsent(state, s -> new HashMap<>()).put(sum, c);
      }
    }
    stateToSumToProbability[state][sum] = bestProbability;
    return bestProbability;
  }

  private static List<List<Integer>> getCombinations(final int sum, final int state) {
    final List<Integer> candidates = getList(state);
    final List<List<Integer>> result = new ArrayList<>();
    getCombinations(result, sum, candidates, new ArrayList<>(), 0);
    return result;
  }

  private static void getCombinations(final List<List<Integer>> result, final int sum,
                                      final List<Integer> candidates, final List<Integer> curPath,
                                      final int startIndex) {
    if (sum < 0) {
      return;
    }
    if (sum == 0) {
      result.add(new ArrayList<>(curPath));
      return;
    }
    if (startIndex == candidates.size()) {
      return;
    }

    for (int i = startIndex; i < candidates.size(); i++) {
      final int candidate = candidates.get(i);
      curPath.add(candidate);
      getCombinations(result, sum - candidate, candidates, curPath, i + 1);
      curPath.remove(curPath.size() - 1);
    }
  }

  private static List<Integer> getList(final int state) {
    final List<Integer> result = new ArrayList<>();
    for (int i = 1; i <= MAX_BOX; i++) {
      if (((state >> (i - 1)) & 1) == 1) {
        result.add(i);
      }
    }
    return result;
  }

  private static int getNextState(final int state, final List<Integer> combination) {
    int res = state;
    for (int c : combination) {
      final int v = 1 << (c - 1);
      assert (v & state) != 0;
      res -= v;
    }
    return res;
  }

  private static int getInitState() {
    int res = 0;
    for (int i = 1; i <= MAX_BOX; i++) {
      res = ((res << 1) | 1);
    }

    assert res == 0b1_1111_1111;
    return res;
  }


  // test method
  public double[][] getCache() {
    return stateToSumToProbability;
  }

  public Map<Integer, Map<Integer, List<Integer>>> getCombinations() {
    return new HashMap<>(stateToSumToCombinations);
  }
}
