package _301_350._316_Remove_Duplicate_Letters;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 9/20/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testBcabc () {
    final String input = "bcabc";
    assertEquals("abc", solution.removeDuplicateLetters(input));
  }

  @Test
  public void testCbacdcbc () {
    final String input = "cbacdcbc";
    assertEquals("acdb", solution.removeDuplicateLetters(input));
  }

  @Test
  public void testBaa() throws Exception {
    final String input = "baa";
    assertEquals("ba", solution.removeDuplicateLetters(input));

  }

  @Test
  public void testBaab() throws Exception {
    final String input = "baab";
    assertEquals("ab", solution.removeDuplicateLetters(input));

  }

  @Test
  public void testBaabc() throws Exception {
    final String input = "bababc";
    assertEquals("abc", solution.removeDuplicateLetters(input));

  }

  @Test
  public void testabacb() throws Exception {
    final String input = "abacb";
    assertEquals("abc", solution.removeDuplicateLetters(input));

  }
}
