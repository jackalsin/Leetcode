package _201_250._220_Contains_Duplicate_III;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/14/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testPositive() throws Exception {
    final int[] input = new int[] {1, 5, 66, 5, 3};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 2, 2));
  }


  @Test
  public void testNegativeT() throws Exception {
    final int[] input = new int[] {1, 5, 1, 66, 5, 3};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 1, 65));
  }

  @Test
  public void testNegativeK() throws Exception {
    final int[] input = new int[] {1, 10000, 66};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 1, 65));
  }

  @Test
  public void test1And1() throws Exception {
    final int[] input = new int[] {1};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 1, 1));
  }

  @Test
  public void test1And3And1() throws Exception {
    final int[] input = new int[] {1, 3, 1};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 2, 1));
  }

  @Test
  public void testK0() throws Exception {
    final int[] input = new int[] {1, 2};
    assertFalse(solution.containsNearbyAlmostDuplicate(input, 0, 1));
  }

  @Test
  public void testOverflow() throws Exception {
    final int a = 2147483647;
    final int[] input = new int[] {0, a};
    assertTrue(solution.containsNearbyAlmostDuplicate(input, 1, a));
  }
}
