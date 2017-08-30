package _251_300._269_Alien_Dictionary;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/29/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testExample1() throws Exception {
    assertEquals("wertf", solution.alienOrder(new String[] {"wrt", "wrf", "er", "ett", "rftt"}));
  }

  @Test
  public void testExample2() throws Exception {
    assertEquals("zx", solution.alienOrder(new String[] {"z", "x"}));
  }

  @Test
  public void testExample3() throws Exception {
    assertEquals("", solution.alienOrder(new String[] {"z", "x", "z"}));
  }

  @Test
  public void testFailed() throws Exception {
    assertEquals("acb", solution.alienOrder(new String[] {"ac", "ab", "b"}));
  }

  @Test
  public void testFailed2() throws Exception {
    assertEquals("acb", solution.alienOrder(new String[] {"ac", "ab", "b"}));
  }
}
