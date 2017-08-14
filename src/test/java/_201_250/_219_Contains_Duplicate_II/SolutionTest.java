package _201_250._219_Contains_Duplicate_II;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testEmpty() throws Exception {
    assertFalse(solution.containsNearbyDuplicate(new int[]{}, 0));
  }


  @Test
  public void testUnorderedArray() throws Exception {
    final int[] input = new int[] {1, 5, -3, 5, 2, 11, 7};
    assertFalse(solution.containsNearbyDuplicate(input, 4));
  }
}
