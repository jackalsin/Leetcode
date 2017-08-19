package _201_250._231_Power_of_Two;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/17/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testPositive() throws Exception {
    int n = 1;
    for (int i = 0; i < 31; ++i) {
      n = 1 << i;
      assertTrue(solution.isPowerOfTwo(n));
    }
  }

  @Test
  public void testNegative() throws Exception {
    assertFalse(solution.isPowerOfTwo(Integer.MIN_VALUE));
  }

  @Test
  public void test3() throws Exception {
    assertFalse(solution.isPowerOfTwo(3));
  }

}
