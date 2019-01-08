package interviews.uber._399_Evaluate_Division;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String[][] equations = {{"a", "b"}, {"b", "c"}};
    final double[] values = {2.0, 3.0};
    final String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
    final double[] expected = {6.00000, 3.00000, -1.00000, 1.00000, -1.00000};
    final double[] actual = solution.calcEquation(equations, values, queries);
    assertArrayEquals(expected, actual, 1E-5);
  }

}