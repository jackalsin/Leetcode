package _201_250._227_Basic_Calculator_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new GenericSolution();
  }

  @Test
  void testOnline1() {
    final String input = "3+2*2";
    assertEquals(7, solution.calculate(input));
  }

  @Test
  void testOnline2() {
    final String input = " 3/2 ";
    assertEquals(1, solution.calculate(input));
  }

  @Test
  void testOnline3() {
    final String input = " 3+5 / 2 ";
    assertEquals(5, solution.calculate(input));
  }
}
