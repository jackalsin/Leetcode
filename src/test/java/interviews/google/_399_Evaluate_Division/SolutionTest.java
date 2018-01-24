package interviews.google._399_Evaluate_Division;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 1/23/2018.
 */
public class SolutionTest {
  private static final double BIAS = 1E-8;
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final String[][] equations = {{"a", "b"}, {"b", "c"}};
    final double[] values = {2.0, 3.0};
    final String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
    final double[] expected = {6.0, 0.5, -1.0, 1.0, -1.0};
    final double[] actual = solution.calcEquation(equations, values, queries);
    assertArrayEquals(expected, actual, BIAS);
  }
}
