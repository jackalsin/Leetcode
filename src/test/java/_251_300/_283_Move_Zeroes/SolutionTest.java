package _251_300._283_Move_Zeroes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 9/4/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnline() throws Exception {
    final int[] input = new int[] {0, 1, 0, 3, 12};
    final int[] expected = new int[] {1, 3, 12, 0, 0};
    solution.moveZeroes(input);
    assertArrayEquals(expected, input);
  }
}
