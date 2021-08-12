package _0551_0600._583_Delete_Operation_for_Two_Strings;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 12/21/2017.
 */
public class SolutionTest {
  private Solution solution;

  @BeforeEach
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
  public void testLaterIsLarger() {
    final String word1 = "abdefccc", word2 = "accc";
    assertEquals(4, solution.minDistance(word1, word2));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final String word1 = "food", word2 = "money";
    assertEquals(7, solution.minDistance(word1, word2));
  }
}
