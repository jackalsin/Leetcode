package _351_400._351_Android_Unlock_Patterns;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/8/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCaseM1N1() throws Exception {
    assertEquals(9, solution.numberOfPatterns(1, 1));
  }

  @Test
  public void testOnlineCaseM1N2() throws Exception {
    assertEquals(65, solution.numberOfPatterns(1, 2));
  }

}
