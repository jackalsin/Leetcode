package uber._227_Basic_Calculator_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/21/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnline1() throws Exception {
    final String input = "3+2*2";
    assertEquals(7, solution.calculate(input));
  }

  @Test
  void testOnline2() throws Exception {
    final String input = " 3/2 ";
    assertEquals(1, solution.calculate(input));
  }

  @Test
  void testOnline3() throws Exception {
    final String input = " 3+5 / 2 ";
    assertEquals(5, solution.calculate(input));
  }
}
