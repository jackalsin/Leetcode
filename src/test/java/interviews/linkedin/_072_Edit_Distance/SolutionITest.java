package interviews.linkedin._072_Edit_Distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  void testWithEmptyCouples() throws Exception {
    assertEquals(0, solution.minDistance("", ""));
  }

  @Test
  void testWithEmpty() throws Exception {
    assertEquals(5, solution.minDistance("", "word1"));
  }

  @Test
  void testWithCommonCase1() throws Exception {
    assertEquals(2, solution.minDistance("word", "wcd"));
  }

}