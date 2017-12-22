package _551_600._583_Delete_Operation_for_Two_Strings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String word1 = "sea", word2 = "eat";
    assertEquals(2, solution.minDistance(word1, word2));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String word1 = "ab", word2 = "a";
    assertEquals(1, solution.minDistance(word1, word2));
  }


  @Test
  public void testLaterIsLarger() throws Exception {
    final String word1 = "abdefccc", word2 = "accc";
    assertEquals(4, solution.minDistance(word1, word2));
  }
}
