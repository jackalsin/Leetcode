package _0601_0650._647_Palindromic_Substrings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/15/2017.
 */
public class SolutionTest {

  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new ONSquareSolution();
  }

  @Test
  public void testAaa() throws Exception {
    assertEquals(6, solution.countSubstrings("aaa"));
  }

  @Test
  public void testEmpty() throws Exception {
    assertEquals(0, solution.countSubstrings(""));
  }

  @Test
  public void testAbc() throws Exception {
    assertEquals(3, solution.countSubstrings("abc"));
  }

}
