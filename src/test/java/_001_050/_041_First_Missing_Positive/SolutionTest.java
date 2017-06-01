package _001_050._041_First_Missing_Positive;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/20/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testMissing1() throws Exception {
    final int[] input = new int[] { 0, -1, 3, 5, 2};
    assertEquals(1, solution.firstMissingPositive(input));
  }

  @Test
  public void testWith1ToN() throws Exception {
    final int[] input = new int[]{1,2,3,4};
    assertEquals(5, solution.firstMissingPositive(input));
  }
}