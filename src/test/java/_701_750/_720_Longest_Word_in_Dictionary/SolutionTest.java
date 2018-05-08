package _701_750._720_Longest_Word_in_Dictionary;

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
    final String[] words = {"w", "wo", "wor", "worl", "world"};
    final String expected = "world";
    assertEquals(expected, solution.longestWord(words));
  }

  @Test
  void testOnlineCase2() {
    final String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
    final String expected = "apple";
    assertEquals(expected, solution.longestWord(words));
  }

  @Test
  void testFailedOnDuplication() {
    final String[] words = {"rac", "rs", "ra", "on", "r", "otif", "o", "onpdu", "rsf", "rs", "ot", "oti", "racy", "onpd"};
    final String expected = "otif";
    assertEquals(expected, solution.longestWord(words));
  }
}