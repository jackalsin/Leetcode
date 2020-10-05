package _0751_0800._774_Minimize_Max_Distance_to_Gas_Station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/5/2018.
 */
class BinarySearchSolutionTest {
  private static final double BIAS = 1E-6;
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new BinarySearchSolution();
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[] gasStation = {0, 1, 4, 9, 18};
    final double actual = solution.minmaxGasDist(gasStation, 2);
    assertEquals(4.5, actual, BIAS);
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[] gasStation = {0, 1, 4, 9, 18};
    final double actual = solution.minmaxGasDist(gasStation, 1);
    assertEquals(5, actual, BIAS);
  }
}
