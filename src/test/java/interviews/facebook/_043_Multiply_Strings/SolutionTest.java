package interviews.facebook._043_Multiply_Strings;

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
  void testWith11And11() {
    // no carry
    assertEquals("121", solution.multiply("11", "11"));

  }

  @Test
  void testWith233And233() {
    // no carry
    assertEquals("54289", solution.multiply("233", "233"));
  }

  @Test
  void testWithLeadingZero() {
    assertEquals(String.valueOf(43 * 27), solution.multiply("43", "27"));
  }

  @Test
  void testOnlineCase1() {
    assertEquals(String.valueOf(0), solution.multiply("0", "0"));
  }
}