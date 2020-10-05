package _0651_0700._672_Bulb_Switcher_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/5/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  /**
   * Consider the duplication choose. 1 + 1 + 1
   *
   * @throws Exception
   */
  @Test
  public void test3And3() throws Exception {
    assertEquals(8, solution.flipLights(3, 3));
  }

  @Test
  public void test1And1() throws Exception {
    assertEquals(2, solution.flipLights(1, 1));
  }

  @Test
  public void test2And1() throws Exception {
    assertEquals(3, solution.flipLights(2, 1));
  }

  @Test
  public void test3And1() throws Exception {
    assertEquals(4, solution.flipLights(3, 1));
  }

  @Test
  public void test3And2() throws Exception {
    assertEquals(7, solution.flipLights(3, 2));
  }

}
