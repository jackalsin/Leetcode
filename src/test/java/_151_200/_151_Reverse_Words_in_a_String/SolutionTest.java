package _151_200._151_Reverse_Words_in_a_String;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 7/15/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    String input = "the sky is blue";
    String expected = "blue is sky the";
    assertEquals(expected, solution.reverseWords(input));
  }

  @Test
  public void testSpace() throws Exception {
    String input = " ";
    String expected = "";
    assertEquals(expected, solution.reverseWords(input));
  }

  @Test
  public void testFailed() throws Exception {
    String input = " 1";
    String expected = "1";
    assertEquals(expected, solution.reverseWords(input));
  }

}
