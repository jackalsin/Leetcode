package _0301_0350._345_Reverse_Vowels_of_a_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/7/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "hello";
    final String expected = "holle";
    assertEquals(expected, solution.reverseVowels(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "leetcode";
    final String expected = "leotcede";
    assertEquals(expected, solution.reverseVowels(input));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String input = "EO";
    final String expectd = "OE";
    assertEquals(expectd, solution.reverseVowels(input));
  }
}
