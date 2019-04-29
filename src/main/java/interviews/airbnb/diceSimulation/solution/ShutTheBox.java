package interviews.airbnb.diceSimulation.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShutTheBox {
  int STATE; // using bit to represent which bits are available
  Double[][] probability; // memorization
  double[] numberProb; // from 2 to 12, the probability of each number
  List[][] combinations;

  // recursion with memorization
  public ShutTheBox() {
    STATE = 0;
    for (int i = 1; i <= 9; i++) {
      STATE += (1 << i);
    }

    probability = new Double[STATE + 1][13]; // only 2 to 12 is meaningful
    combinations = new List[STATE + 1][13];
    numberProb = calNumberProb();
    for (int c = 2; c <= 12; c++) dfs(STATE, c, probability);
  }

  private double dfs(int curState, int c, Double[][] probablity) {
    // recursion with memorization
    if (probablity[curState][c] != null) return probablity[curState][c];
    //base case;
    if (curState == 0) {
      probablity[curState][c] = 1.0;
      return 1.0;
    }

    // find combinations that can construct c from state
    // c is the number from rolling the dice
    List<List<Integer>> combs = findComb(curState, c);
    if (combs.size() == 0) {
      probablity[curState][c] = 0.0;
      return 0.0;
    }
    double bestProb = 0.0;
    for (List<Integer> comb : combs) {
      int nextState = getNextState(curState, comb);
      double localProb = 0.0;
      for (int nc = 2; nc <= 12; nc++) {
        localProb += numberProb[nc] * dfs(nextState, nc, probablity);
      }
      if (localProb > bestProb) {
        bestProb = localProb;
        combinations[curState][c] = comb;
      }
    }
    probablity[curState][c] = bestProb;
    return bestProb;
  }

  private List<List<Integer>> findComb(int curState, int c) {
    List<Integer> choices = new ArrayList<>();
    for (int i = 1; i <= 9; i++) {
      if ((curState & (1 << i)) > 0) {
        choices.add(i);
      }
    }
    List<List<Integer>> combinations = new ArrayList<>();
    findCombDfs(choices, c, 0, combinations, 0, new ArrayList<>());
    return combinations;
  }

  private void findCombDfs(List<Integer> choices, int c,
                           int index, List<List<Integer>> combinations,
                           int sum, List<Integer> list) {
    if (sum > c || c < 2) return;
    if (sum == c) {
      combinations.add(new ArrayList<>(list));
      return;
    }
    for (int i = index; i < choices.size(); i++) {
      if (sum + choices.get(i) <= c) {
        list.add(choices.get(i));
        findCombDfs(choices, c, i + 1,
            combinations, sum + choices.get(i), list);
        list.remove(list.size() - 1);
      }
    }
  }

  private int getNextState(int curState, List<Integer> comb) {
    for (int n : comb) curState -= (1 << n);
    return curState;
  }

  public double[] calNumberProb() {
    double[] ans = new double[13];
    for (int i = 1; i <= 6; i++) {
      for (int j = 1; j <= 6; j++) {
        ans[i + j] += 1.0 / 6.0 / 6.0;
      }
    }
    return ans;
  }

  public List<Integer> pick(int curState, int c) {
    return combinations[curState][c];
  }

  /////// Test code

  public static Random random;

  public static int rollDice() {
    return random.nextInt(6) + random.nextInt(6) + 2;
  }

  public static void main(String[] args) {
    ShutTheBox stb = new ShutTheBox();
    random = new Random();
    int trialNumber = 100_000;
    int cnt = 0;
    for (int i = 0; i < trialNumber; i++) {
      if (runOnce(stb)) cnt++;
    }
    System.out.println(cnt * 1.0 / trialNumber);
  }

  public static boolean runOnce(ShutTheBox stb) {
    int curState = stb.STATE;
    while (true) {
      int c = rollDice();
      List<Integer> comb = stb.pick(curState, c);
      if (comb == null || comb.size() == 0) {
        return false;
      } else {
        curState = stb.getNextState(curState, comb);
        if (curState == 0) {
          return true;
        }
      }
    }
  }

}
