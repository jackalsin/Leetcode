package interviews.linkedin._072_Edit_Distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionII();
  }

  @Test
  void testWithEmptyCouples() {
    assertEquals(0, solution.minDistance("", ""));
  }

  @Test
  void testWithEmpty() {
    assertEquals(5, solution.minDistance("", "word1"));
  }

  @Test
  void testWithCommonCase1() {
    assertEquals(2, solution.minDistance("word", "wcd"));
  }

  @Test
  void testWithFailedCase1() {
    assertEquals(5, solution.minDistance("intention", "execution"));
  }

}