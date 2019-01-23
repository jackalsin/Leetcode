package _0001_0050._043_Multiply_Strings;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/22/2017.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();

  }

  @Test
  void testWith11And11() throws Exception {
    // no carry
    assertEquals("121", solution.multiply("11", "11"));

  }

  @Test
  void testWith233And233() throws Exception {
    // no carry
    assertEquals("54289", solution.multiply("233", "233"));
  }

  @Test
  void testWithLeadingZero() throws Exception {
    assertEquals(String.valueOf(43 * 27), solution.multiply("43", "27"));
  }
}