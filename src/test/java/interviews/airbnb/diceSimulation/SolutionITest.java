package interviews.airbnb.diceSimulation;

import interviews.airbnb.diceSimulation.solution.Solution;
import interviews.airbnb.diceSimulation.solution.SolutionI;
import org.junit.jupiter.api.Test;

class SolutionITest {
  private DiceSimulator simulator;

  @Test
  void testOnlineCase1() {
    final Solution solution = new SolutionI();
    int success = 0, N = 1_000_000;
    for (int i = 0; i < N; i++) {
      simulator = new DiceSimulator();
      final boolean res = simulator.solve(solution);
      if (res) success++;
    }

    System.out.println((double) success / N);
  }

}