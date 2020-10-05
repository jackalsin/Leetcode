package airbnb._041_First_Missing_Positive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
class NonConstantSpaceTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new NonConstantSpace();
  }

  @Test
  void testMissing1() {
    final int[] input = new int[]{0, -1, 3, 5, 2};
    assertEquals(1, solution.firstMissingPositive(input));
  }

  @Test
  void testWith1ToN() {
    final int[] input = new int[]{1, 2, 3, 4};
    assertEquals(5, solution.firstMissingPositive(input));
  }

  @Test
  void testWith0ToNMinus1() {
    final int[] input = new int[]{0, 1, 2};
    assertEquals(3, solution.firstMissingPositive(input));
  }
}