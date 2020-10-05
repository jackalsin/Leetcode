package microsoft._165_Compare_Version_Numbers;

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
  void testEqualNormal() {
    assertEquals(0, solution.compareVersion("0", "0"));
  }

  @Test
  void testEqualDigitsDiff() {
    assertEquals(0, solution.compareVersion("0.0.0", "0"));
  }

  @Test
  void testGreaterWithTheSameDigits() {
    assertEquals(1, solution.compareVersion("1.11.2", "1.11.1"));
  }

  @Test
  void testGreaterWithDiffDigit() {
    assertEquals(1, solution.compareVersion("1.11.2", "1.11"));
  }

  @Test
  void testGreaterWithDiffDigits() {
    assertEquals(1, solution.compareVersion("1.11.2", "1"));
  }

}