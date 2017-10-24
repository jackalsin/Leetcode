package interviews.linkedin._647_Palindromic_Substrings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/24/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testFailed() throws Exception {
    final String s = "fdsklf";
    assertEquals(6, solution.countSubstrings(s));
  }
}
