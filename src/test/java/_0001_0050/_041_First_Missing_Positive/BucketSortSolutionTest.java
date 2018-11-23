package _0001_0050._041_First_Missing_Positive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 09/03/2018
 */
class BucketSortSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new BucketSortSolution();
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
}