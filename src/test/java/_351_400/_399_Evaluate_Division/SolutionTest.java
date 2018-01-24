package _351_400._399_Evaluate_Division;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 11/11/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[][] equations = { {"a", "b"},  {"b", "c"}};
    final double[] values = {2.0, 3.0};
    final String[][] queries = {{"a", "c"}, {"b", "c"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
    final double[] expected = {6.00000,3.00000,-1.00000,1.00000,-1.00000};
    final double[] actual = solution.calcEquation(equations, values, queries);
    assertArrayEquals(expected, actual, 1E-5);
  }

  @Test
  public void testEmpty() throws Exception {

  }

}
