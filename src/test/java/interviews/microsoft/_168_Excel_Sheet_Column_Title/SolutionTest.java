package interviews.microsoft._168_Excel_Sheet_Column_Title;

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
  void testSingle() {
    assertEquals("A", solution.convertToTitle(1));
    assertEquals("Z", solution.convertToTitle(26));
  }

  @Test
  void testDouble() {
    assertEquals("AB", solution.convertToTitle(26 * 1 + 2));
    assertEquals("AZ", solution.convertToTitle(26 * 1 + 26));
  }

  @Test
  void testTriple() {
    assertEquals("AAB", solution.convertToTitle(26 * 26 * 1 + 26 * 1 + 2));
  }

}