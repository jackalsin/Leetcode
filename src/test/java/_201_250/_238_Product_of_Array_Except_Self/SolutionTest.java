package _201_250._238_Product_of_Array_Except_Self;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/19/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = new int[] {1, 2, 3, 4};
    final int[] expected = new int[] {24, 12, 8, 6};
    assertArrayEquals(expected, solution.productExceptSelf(input));
  }
}
