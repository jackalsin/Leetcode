package _0251_0300._263_Ugly_Number;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 8/28/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void test1() throws Exception {
    assertTrue(solution.isUgly(1));
  }

  @Test
  public void test2() throws Exception {
    assertTrue(solution.isUgly(2));
  }

  @Test
  public void test3() throws Exception {
    assertTrue(solution.isUgly(3));
  }

  @Test
  public void test5() throws Exception {
    assertTrue(solution.isUgly(5));
  }

  @Test
  public void test14() throws Exception {
    assertFalse(solution.isUgly(14));
  }

  @Test
  public void test0() throws Exception {
    assertFalse(solution.isUgly(0));
  }

}
