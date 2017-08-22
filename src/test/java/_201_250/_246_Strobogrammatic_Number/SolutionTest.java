package _201_250._246_Strobogrammatic_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/21/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test6() throws Exception {
    assertFalse(solution.isStrobogrammatic("6"));
    assertFalse(solution.isStrobogrammatic("2"));
  }

  @Test
  public void test69() throws Exception {
    assertTrue(solution.isStrobogrammatic("69"));
    assertTrue(solution.isStrobogrammatic("88"));
    assertTrue(solution.isStrobogrammatic("818"));
  }
}
