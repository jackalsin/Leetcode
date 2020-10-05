package _0451_0500._459_Repeated_Substring_Pattern;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    assertTrue(solution.repeatedSubstringPattern("abab"));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    assertFalse(solution.repeatedSubstringPattern("aba"));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    assertTrue(solution.repeatedSubstringPattern("abcabcabcabc"));
  }

  @Test
  public void testAA() throws Exception {
    assertTrue(solution.repeatedSubstringPattern("aa"));
  }


}
