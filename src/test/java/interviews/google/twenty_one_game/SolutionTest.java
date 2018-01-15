package interviews.google.twenty_one_game;

import org.junit.Before;
import org.junit.Test;

/**
 * @author jacka
 * @version 1.0 on 1/14/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testCase1() throws Exception {
    final double res = solution.largerThan21();
    System.out.println(res);
  }
}
