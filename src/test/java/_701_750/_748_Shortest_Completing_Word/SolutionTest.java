package _701_750._748_Shortest_Completing_Word;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String licensePlate = "1s3 PSt", expected = "steps";
    final String[] words = {"step", "steps", "stripe", "stepple"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String licensePlate = "1s3 456", expected = "pest";
    final String[] words = {"looks", "pest", "stew", "show"};
    assertEquals(expected, solution.shortestCompletingWord(licensePlate, words));
  }

}