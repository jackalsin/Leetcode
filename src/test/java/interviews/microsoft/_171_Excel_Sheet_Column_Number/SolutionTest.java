package interviews.microsoft._171_Excel_Sheet_Column_Number;

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
    assertEquals(26, solution.titleToNumber("Z"));
    assertEquals(1, solution.titleToNumber("A"));
  }

  @Test
  void testDouble() {
    assertEquals(27, solution.titleToNumber("AA"));
    assertEquals(52, solution.titleToNumber("AZ"));
  }

}