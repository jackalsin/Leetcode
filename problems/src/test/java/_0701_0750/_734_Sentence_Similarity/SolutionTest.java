package _0701_0750._734_Sentence_Similarity;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/4/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final String[] word1 = {"great", "acting", "skills"}, word2 = new String[] {"fine", "drama",
        "talent"};
    final String[][] pairs =
        {{"great", "fine"}, {"drama", "acting"}, {"skills", "talent"}};
    assertTrue(solution.areSentencesSimilar(word1, word2, pairs));
  }
}
