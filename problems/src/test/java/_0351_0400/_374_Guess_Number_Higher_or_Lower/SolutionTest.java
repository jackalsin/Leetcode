package _0351_0400._374_Guess_Number_Higher_or_Lower;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 11/7/2017.
 */
public class SolutionTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int pick = 6;
    final Solution solution = new Solution(pick);
    assertEquals(6, solution.guessNumber(10));
  }

  @Test
  public void testGuess() throws Exception {
    final Solution solution = new Solution(6);

    assertEquals(-1, solution.guess(10));
    assertEquals(0, solution.guess(6));
    assertEquals(1, solution.guess(3));
  }

}
