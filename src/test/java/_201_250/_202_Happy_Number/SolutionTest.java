package _201_250._202_Happy_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testIsHappy() throws Exception {
    assertTrue(solution.isHappy(19));
  }

  @Test
  public void test887() throws Exception {
    assertFalse(solution.isHappy(887));
  }


}
