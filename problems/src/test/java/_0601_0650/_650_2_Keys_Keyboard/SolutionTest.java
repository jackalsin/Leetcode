package _0601_0650._650_2_Keys_Keyboard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/30/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  public void test0() throws Exception {
    assertEquals(0, solution.minSteps(0));
  }

  @Test
  public void test1() throws Exception {
    assertEquals(0, solution.minSteps(1));
  }

  @Test
  public void test2() throws Exception {
    assertEquals(2, solution.minSteps(2));
  }

  @Test
  public void test3() throws Exception {
    assertEquals(3, solution.minSteps(3));
  }

  /**
   * Do notice, copy also counts as operations
   */
  @Test
  public void test4() throws Exception {
    assertEquals(4, solution.minSteps(4));
  }

  @Test
  public void test5() throws Exception {
    assertEquals(5, solution.minSteps(5));
  }

  @Test
  public void test6() throws Exception {
    assertEquals(5, solution.minSteps(6));
  }

  @Test
  public void test7() throws Exception {
    assertEquals(7, solution.minSteps(7));
  }

  @Test
  public void test144() throws Exception {
    assertEquals(14, solution.minSteps(144));
  }

}
