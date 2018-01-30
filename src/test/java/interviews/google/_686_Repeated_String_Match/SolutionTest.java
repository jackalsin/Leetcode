package interviews.google._686_Repeated_String_Match;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new KMPSolution();
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

  @Test
  public void testGetNext1() throws Exception {
    final String str = "cdabcdab";
    final int[] actual = new KMPSolution().getNext(str);
    final int[] expected = {0, 0, 0, 0, 0, 1, 2, 3, 4};
    assertArrayEquals(expected, actual);
  }

  @Test
  public void testGetNext2() throws Exception {
    final String str = "cdabcdaba";
    final int[] actual = new KMPSolution().getNext(str);
    final int[] expected = {0, 0, 0, 0, 0, 1, 2, 3, 4, 0};
    assertArrayEquals(expected, actual);
  }
}
