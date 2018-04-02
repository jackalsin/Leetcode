package interviews.uber._418_Sentence_Screen_Fitting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/1/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String[] sentence = {"hello", "world"};
    assertEquals(1, solution.wordsTyping(sentence, 2, 8));
  }

  @Test
  void testOnlineCase2() {
    final String[] sentence = {"a", "bcd", "e"};
    assertEquals(2, solution.wordsTyping(sentence, 3, 6));
  }

  @Test
  void testOnlineCase3() {
    final String[] sentence = {"I", "had", "apple", "pie"};
    assertEquals(1, solution.wordsTyping(sentence, 4, 5));
  }

  @Test
  void testFailedCase1() {
    final String[] sentence = {"try", "to", "be", "better"};
    assertEquals(5293333, solution.wordsTyping(sentence, 10000, 9001));
  }

  @Test
  void testFailedCase2() {
    final String[] sentence = {"hello"};
    assertEquals(0, solution.wordsTyping(sentence, 10000, 1));
  }

  @Test
  void testTLECase() {
    final String[] sentence = {"a", "b", "e"};
    assertEquals(66666666, solution.wordsTyping(sentence, 20000, 20000));
  }


}
