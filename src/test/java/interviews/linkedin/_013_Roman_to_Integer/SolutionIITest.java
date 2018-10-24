package interviews.linkedin._013_Roman_to_Integer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionII();
  }

  @Test
  void testOneDigit() throws Exception {
    assertEquals(9, solution.romanToInt("IX"));
  }
}