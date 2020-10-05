package airbnb.redWhiteBall;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private static final double DELTA = 1E-6;
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new DfsMemoSolution();
  }

  @Test
  void testOnlineCaseAllRed10() {
    assertEquals(1, solution.getProbability(10, 0), DELTA);
  }

  @Test
  void testOnlineCaseAllRed6() {
    assertEquals(1, solution.getProbability(6, 0), DELTA);
  }

  @Test
  void testOnlineCaseR6W1() {
    assertEquals(0.4285714285714285, solution.getProbability(6, 1), DELTA);
  }

  @Test
  void testOnlineCaseR9W8() {
    assertEquals(0.24063177682203415, solution.getProbability(9, 8), DELTA);
  }

  @Disabled
  @Test
  void testSimulatorR9W8N1M() {
    final Simulator simulator = new Simulator();
    System.out.println(simulator.getProbability(9, 8, 1_000_000));
  }

  @Disabled
  @Test
  void testSimulatorR6W1N1M() {
    final Simulator simulator = new Simulator();
    System.out.println(simulator.getProbability(6, 1, 1_000_000));
  }
}