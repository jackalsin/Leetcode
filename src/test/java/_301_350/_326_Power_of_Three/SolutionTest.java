package _301_350._326_Power_of_Three;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/25/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testAllPositive() throws Exception {
    int cur = 1;
    for (int i = 0; i <= 19; i++) {
      assertTrue(solution.isPowerOfThree(cur));
      cur *= 3;
    }
  }

}
