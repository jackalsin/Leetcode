package interviews.microsoft._013_Roman_to_Integer;

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
  void testOneDigit() {
    assertEquals(9, solution.romanToInt("IX"));
  }

  @Test
  void test1994() {
    assertEquals(1994, solution.romanToInt("MCMXCIV"));
  }


}