package linkedin._013_Roman_to_Integer;

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
  void testOneDigit() {
    assertEquals(9, solution.romanToInt("IX"));
  }

  @Test
  void testMCMXCIV() {
    assertEquals(1994, solution.romanToInt("MCMXCIV"));
  }
}