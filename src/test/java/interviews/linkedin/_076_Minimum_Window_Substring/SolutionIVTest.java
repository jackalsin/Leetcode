package interviews.linkedin._076_Minimum_Window_Substring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIVTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionIV();
  }

  @Test
  void testWithOnlineCase() {
    assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
  }

}