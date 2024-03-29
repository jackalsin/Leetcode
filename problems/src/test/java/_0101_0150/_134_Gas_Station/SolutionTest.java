package _0101_0150._134_Gas_Station;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 7/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testNegativeOneElement() throws Exception {
    final int[] gas = new int[] {4};
    final int[] cost = new int[] {6};
    assertEquals(-1, solution.canCompleteCircuit(gas, cost));
  }

  @Test
  public void testPositiveOneElement() throws Exception {

    final int[] gas = new int[] {4};
    final int[] cost = new int[] {3};
    assertEquals(0, solution.canCompleteCircuit(gas, cost));
  }
}
