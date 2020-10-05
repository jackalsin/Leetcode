package airbnb.diceSimulation.newSolution;

import org.junit.jupiter.api.RepeatedTest;

class UnlimitedBoxSolutionTest {
  private Solution solution;

  @RepeatedTest(10)
  void testOnlineCase1() {
    int success = 0, N = 10_000_000;
    solution = new UnlimitedBoxSolution();
    System.out.println("start solving");
    for (int i = 0; i < N; i++) {
//      System.out.println(i);
//      final long startTime = System.nanoTime();
      final boolean res = solution.solve();
      if (res) success++;
//      final long endTime = System.nanoTime();
//      System.out.println((endTime - startTime) / 1E6);
    }

    System.out.println((double) success / N);
  }
}