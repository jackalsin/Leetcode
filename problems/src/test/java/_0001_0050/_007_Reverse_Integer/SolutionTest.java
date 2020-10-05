package _0001_0050._007_Reverse_Integer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/12.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void reverseZero() throws Exception {
    assertEquals(0, solution.reverse(0));
  }

  @Test
  void reverseNegativeSingleDigit() throws Exception {
    assertEquals(-1, solution.reverse(-1));
  }

  @Test
  void reverseNegativeTwoDigits() throws Exception {
    assertEquals(-12, solution.reverse(-21));
  }

  @Test
  void reversePositiveSingleDigit() throws Exception {
    assertEquals(1, solution.reverse(1));
  }

  @Test
  void reversePositiveTwoDigits() throws Exception {
    assertEquals(12, solution.reverse(21));
  }

  @Test
  void reverseMinValue() throws Exception {
    assertEquals(0, solution.reverse(Integer.MIN_VALUE));
  }

  @Test
  void reverseOverflow() throws Exception {
    assertEquals(-2143847412, solution.reverse(-2147483412));
  }
}