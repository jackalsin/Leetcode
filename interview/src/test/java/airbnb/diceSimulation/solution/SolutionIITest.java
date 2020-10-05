package airbnb.diceSimulation.solution;

import airbnb.diceSimulation.newSolution.UnlimitedBoxSolution;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @RepeatedTest(10)
  void testOnlineCase1() {
    int success = 0, N = 10_000_000;
    solution = new SolutionII();
    System.out.println("start solving");
    for (int i = 0; i < N; i++) {
      final boolean res = solution.solve();
      if (res) success++;
    }

    System.out.println((double) success / N);
  }


  @Test
  void testListToState1() {
    final List<Integer> input = List.of(1, 3, 5, 9);
    int expected = 0;
    for (int c : input) {
      expected -= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.getNextState(0, input));
  }

  // test state

  @Test
  void testStateToList1() {
    final List<Integer> expected = List.of(1, 3, 5, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }

  @Test
  void testStateToList2() {
    final List<Integer> expected = List.of(2, 3, 5, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }

  @Test
  void testStateToList3() {
    final List<Integer> expected = List.of(1, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }

  @Test
  void testStateToList4() {
    final List<Integer> expected = List.of(1, 2, 3, 4, 5, 9);
    int input = 0;
    for (int c : expected) {
      input |= (1 << (c - 1));
    }
    assertEquals(expected, SolutionII.stateToList(input));
  }


  @Test
  void testProbability() {
    final double[][] unlimitedBoxCache = new UnlimitedBoxSolution().getCache(),
        solutionIICache = new SolutionII().getCache();

    assertEquals(unlimitedBoxCache.length, solutionIICache.length);
    assertEquals(unlimitedBoxCache[0].length, solutionIICache[0].length);
    final int rows = unlimitedBoxCache.length, cols = unlimitedBoxCache[0].length;
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        assertEquals(solutionIICache[r][c], unlimitedBoxCache[r][c],
            1e-6, String.format("row = %d, col = %d", r, c));
      }
    }
  }

  @Test
  void testCombination() {
    final Map<Integer, Map<Integer, List<Integer>>> unlimitedBoxCombinations = new UnlimitedBoxSolution().getCombinations(),
        solutionIICombinations = new SolutionII().getCombinations();
    assertEquals(unlimitedBoxCombinations, solutionIICombinations);
  }
}