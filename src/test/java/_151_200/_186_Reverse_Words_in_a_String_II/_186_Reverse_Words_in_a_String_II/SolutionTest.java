package _151_200._186_Reverse_Words_in_a_String_II._186_Reverse_Words_in_a_String_II;

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
    char[] input = "the sky is blue".toCharArray();
    char[] expected = "blue is sky the".toCharArray();
    solution.reverseWords(input);
    assertArrayEquals(expected, input);
  }
}
