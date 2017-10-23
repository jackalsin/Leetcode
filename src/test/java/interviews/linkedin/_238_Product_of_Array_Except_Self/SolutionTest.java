package interviews.linkedin._238_Product_of_Array_Except_Self;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final int[] input = {1, 2, 3, 4};
    final int[] expected = {24, 12, 8, 6};
    assertArrayEquals(expected, solution.productExceptSelf(input));
  }

}
