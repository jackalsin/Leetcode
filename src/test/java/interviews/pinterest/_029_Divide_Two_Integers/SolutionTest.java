package interviews.pinterest._029_Divide_Two_Integers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testWithMinimumDividesOne() throws Exception {
    assertEquals(Integer.MIN_VALUE, solution.divide(Integer.MIN_VALUE, 1));
  }

  @Test
  void testWithMinimumDivideNegativeOne() throws Exception {
    assertEquals(Integer.MAX_VALUE, solution.divide(Integer.MIN_VALUE, -1));
  }

  @Test
  void testWithDividendZero() throws Exception {
    assertEquals(0, solution.divide(0, 1));
  }

  @Test
  void testWithDivisorMinValue() throws Exception {
    assertEquals(0, solution.divide(1, Integer.MIN_VALUE));
  }

  @Test
  void testWith32By3() throws Exception {
    assertEquals(32 / 3, solution.divide(32, 3));
  }

  @Test
  void testWith32byN3() throws Exception {
    assertEquals(-32 / 3, solution.divide(-32, 3));
  }

  @Test
  void testWith1By1() throws Exception {
    assertEquals(1 / 1, solution.divide(1, 1));
  }

  @Test
  void testWith2147483647By1() throws Exception {
    assertEquals(2147483647, solution.divide(2147483647, 1));
  }

  @Test
  void testWithIntMinBy2() throws Exception {
    assertEquals(Integer.MIN_VALUE / 2, solution.divide(Integer.MIN_VALUE, 2));
  }

}