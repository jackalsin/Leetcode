package interviews.uber._008_String_to_Integer_atoi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testMaxInteger() {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
  }

  @Test
  void testMinInteger() {
    assertEquals(Integer.MIN_VALUE, solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
  }

  @Test
  void testMinIntegerPlusOne() {
    assertEquals(Integer.MIN_VALUE + 1,
        solution.myAtoi(String.valueOf(Integer.MIN_VALUE + 1)));
  }

  @Test
  void testZero() {
    assertEquals(0, solution.myAtoi(String.valueOf("0")));
  }

  @Test
  void testUpOverflow() {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf("2147483648")));
  }
}