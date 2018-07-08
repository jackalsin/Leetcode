package interviews.microsoft._162_Find_Peak_Element;

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
  void testOneElement() {
    assertEquals(0, solution.findPeakElement(new int[]{Integer.MIN_VALUE}));
    assertEquals(0, solution.findPeakElement(new int[]{0}));
  }

  @Test
  void testTwoElementLeadingPeak() {
    assertEquals(0, solution.findPeakElement(new int[]{1, 0}));
  }

  @Test
  void testTwoElementTrailingPeak() {
    assertEquals(1, solution.findPeakElement(new int[]{0, 1}));
  }
}