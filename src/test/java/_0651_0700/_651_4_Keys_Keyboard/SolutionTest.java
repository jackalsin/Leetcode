package _0651_0700._651_4_Keys_Keyboard;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/31/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertEquals(3, solution.maxA(3));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertEquals(9, solution.maxA(7));
  }

  @Test
  public void test5() throws Exception {
    assertEquals(5, solution.maxA(5));
  }

  @Test
  public void test4() throws Exception {
    assertEquals(6, solution.maxA(6));
  }

}
