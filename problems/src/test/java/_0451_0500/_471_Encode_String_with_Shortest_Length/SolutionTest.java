package _0451_0500._471_Encode_String_with_Shortest_Length;

import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 11/26/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new NaiveOptimalSolution();
//    solution = new ONCubicSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String expected = "aaa", input = "aaa";
    assertEquals(expected, solution.encode(input));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String expected = "5[a]", input = "aaaaa";
    assertEquals(expected, solution.encode(input));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String input = "aaaaaaaaaa";
    final Set<String> expected = Set.of("10[a]", "a9[a]", "9[a]a");
    assertTrue(expected.contains(solution.encode(input)));
  }

  @Test
  public void testOnlineCase4() throws Exception {
    final String expected = "2[aabc]d", input = "aabcaabcd";
    final String actual = solution.encode(input);
    assertEquals(expected, actual);
  }

  @Test
  public void testOnlineCase5() throws Exception {
    final String expected = "2[2[abbb]c]", input = "abbbabbbcabbbabbbc";
    System.out.println("2[2[abbb]c]".length() + " " + "2[abbbabbbc]".length());
    final String actual = solution.encode(input);
    assertEquals(expected, actual);
  }

  @Test
  public void testAbcaabcdWithAbca() throws Exception {
    assertFalse(new NaiveOptimalSolution().isRepeatString("abcaabcd", "abca"));
  }
}
