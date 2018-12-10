package _0801_0850._809_Expressive_Words;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String s = "heeellooo", words[] = {
        "hello", "hi", "helo"
    };
    assertEquals(1, solution.expressiveWords(s, words));
  }

  @Test
  void testFailedCase1() {
    final String s = "zzzzzyyyyy", words[] = {
        "zzyy", "zy", "zyy"
    };
    assertEquals(3, solution.expressiveWords(s, words));
  }
}