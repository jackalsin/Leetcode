package interviews.uber._041_First_Missing_Positive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/14/2018.
 */
class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testMissing1() throws Exception {
    final int[] input = new int[] {0, -1, 3, 5, 2};
    assertEquals(1, solution.firstMissingPositive(input));
  }

  @Test
  void testWith1ToN() throws Exception {
    final int[] input = new int[] {1, 2, 3, 4};
    assertEquals(5, solution.firstMissingPositive(input));
  }

  @Test
  void testDuplicateElements() throws Exception {
    final int[] input = new int[] {1, 1};
    assertEquals(2, solution.firstMissingPositive(input));
  }
}
