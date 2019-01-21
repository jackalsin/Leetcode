package interviews.airbnb._008_String_to_Integer;

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
  void testMaxInteger() throws Exception {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
  }

  @Test
  void testMinInteger() throws Exception {
    assertEquals(Integer.MIN_VALUE, solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
  }

  @Test
  void testMinIntegerPlusOne() throws Exception {
    assertEquals(Integer.MIN_VALUE + 1,
        solution.myAtoi(String.valueOf(Integer.MIN_VALUE + 1)));
  }

  @Test
  void testZero() throws Exception {
    assertEquals(0, solution.myAtoi("0"));
  }

  @Test
  void testUpOverflow() throws Exception {
    assertEquals(Integer.MAX_VALUE, solution.myAtoi("2147483648"));
  }
}