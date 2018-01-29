package interviews.google._686_Repeated_String_Match;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new KMPSoution();
    solution = new NormalSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String A = "abcd", b = "cdabcdab";
    assertEquals(3, solution.repeatedStringMatch(A, b));
  }

  @Test
  public void testIntegerTimes() throws Exception {
    final String A = "a", b = "aa";
    assertEquals(2, solution.repeatedStringMatch(A, b));
  }
}
