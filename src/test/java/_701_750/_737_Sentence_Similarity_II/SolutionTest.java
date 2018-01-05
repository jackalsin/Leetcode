package _701_750._737_Sentence_Similarity_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
    final String[] word1 = {"great", "acting", "skills"}, word2 = {"fine", "drama", "talent"};
    final String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"drama", "acting"}, {"skills",
        "talent"}};
    assertTrue(solution.areSentencesSimilarTwo(word1, word2, pairs));
  }
}
