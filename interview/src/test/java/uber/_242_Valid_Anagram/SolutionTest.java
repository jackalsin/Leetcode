package uber._242_Valid_Anagram;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testExample() {
    final String s = "anagram", t = "nagaram";
    assertTrue(solution.isAnagram(s, t));
  }
}