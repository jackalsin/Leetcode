package _401_450._418_Sentence_Screen_Fitting;

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
    final String[] sentence = {"hello", "world"};
    assertEquals(1, solution.wordsTyping(sentence, 2, 8));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final String[] sentence = {"a", "bcd", "e"};
    assertEquals(2, solution.wordsTyping(sentence, 3, 6));
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final String[] sentence = {"I", "had", "apple", "pie"};
    assertEquals(1, solution.wordsTyping(sentence, 4, 5));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final String[] senetence = {"try", "to", "be", "better"};
    assertEquals(5293333, solution.wordsTyping(senetence, 10000, 9001));
  }

  @Test
  public void testFailedCase2() throws Exception {
    final String[] senetence = {"hello"};
    assertEquals(0, solution.wordsTyping(senetence, 10000, 1));
  }

}