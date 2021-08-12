package microsoft._005_Longest_Palindromic_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/13/2018.
 */
public class CleanSolutionTest {
  private Solution solution;

  @BeforeEach
  public void setUp() throws Exception {
    solution = new CleanSolution();
  }


  @Test
  public void testOnlineCase1() throws Exception {
    final String input = "babad", output = "bab";
    final String actual = solution.longestPalindrome(input);
    assertEquals(output, actual);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String input = "cbbd", output = "bb";
    assertEquals(output, solution.longestPalindrome(input));
  }

}
