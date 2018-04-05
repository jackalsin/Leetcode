package _351_400._383_Ransom_Note;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    assertFalse(solution.canConstruct("a", "b"));
  }

  @Test
  void testOnlineCase2() {
    assertFalse(solution.canConstruct("aa", "ab"));
  }

  @Test
  void testOnlineCase3() {
    assertTrue(solution.canConstruct("aa", "aab"));
  }
}
