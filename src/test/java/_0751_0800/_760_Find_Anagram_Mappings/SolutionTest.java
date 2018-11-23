package _0751_0800._760_Find_Anagram_Mappings;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 1/8/2018.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] A = new int[]{12, 28, 46, 32, 50}, B = {50, 12, 32, 46, 28};
    final int[] expected = new int[]{1, 4, 3, 2, 0};
    final int[] actual = solution.anagramMappings(A, B);
    assertArrayEquals(expected, actual);
  }
}
