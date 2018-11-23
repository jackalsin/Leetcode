package _0001_0050._038_Count_and_Say;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/18/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith1() throws Exception {
    assertEquals("1", solution.countAndSay(1));
  }

  @Test
  public void testWith2() throws Exception {
    assertEquals("11", solution.countAndSay(2));
  }

  @Test
  public void testWith13() throws Exception {
    assertEquals("11131221133112132113212221", solution.countAndSay(11));
  }

}