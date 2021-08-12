package _0401_0450._418_Sentence_Screen_Fitting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new OptimizedSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final String[] sentence = {"hello", "world"};
    assertEquals(1, solution.wordsTyping(sentence, 2, 8));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final String[] sentence = {"a", "bcd", "e"};
    assertEquals(2, solution.wordsTyping(sentence, 3, 6));
  }

  @Test
  void testOnlineCase3() throws Exception {
    final String[] sentence = {"I", "had", "apple", "pie"};
    assertEquals(1, solution.wordsTyping(sentence, 4, 5));
  }

  @Test
  void testFailedCase1() throws Exception {
    final String[] sentence = {"try", "to", "be", "better"};
    assertEquals(5293333, solution.wordsTyping(sentence, 10000, 9001));
  }

  @Test
  void testFailedCase2() throws Exception {
    final String[] sentence = {"hello"};
    assertEquals(0, solution.wordsTyping(sentence, 10000, 1));
  }

  @Test
  void testTLECase() {
    final String[] sentence = {"a", "b", "e"};
    Assertions.assertEquals(66666666, solution.wordsTyping(sentence, 20000, 20000));
  }
}
