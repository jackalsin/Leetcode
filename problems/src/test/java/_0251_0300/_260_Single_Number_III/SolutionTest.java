package _0251_0300._260_Single_Number_III;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 8/27/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testCase1() throws Exception {
    final int[] nums = new int[]{1, 2, 1, 3, 2, 5};
    final int[] expected = new int[]{3, 5};
    final int[] actual = solution.singleNumber(nums);
    Arrays.sort(actual);
    assertArrayEquals(expected, actual);

  }
}
