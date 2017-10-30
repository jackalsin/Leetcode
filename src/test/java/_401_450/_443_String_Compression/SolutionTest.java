package _401_450._443_String_Compression;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    final char[] expected = {'a', '2', 'b', '2', 'c', '3'};
    final int range = solution.compress(input);
    System.out.println(range);
    System.out.println(Arrays.toString(input));
    assertArrayEquals(expected, input, range);
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final char[] input = {'a'};
    final char[] expected = {'a'};
    final int range = solution.compress(input);
    assertArrayEquals(expected, input, range);
  }

  @Test
  public void testOnlineCase3() throws Exception {
    final char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    final char[] expected = {'a', 'b', '1', '2'};
    final int range = solution.compress(input);
    assertArrayEquals(expected, input, range);
  }

  /**
   * This one fails when we didn't update the target character.
   */
  @Test
  public void testFailedOnNotUpdateChar() throws Exception {
    final char[] input = {'a', 'a', 'a', 'b', 'b', 'a', 'a'};
    final char[] expected = {'a', '3', 'b', '2', 'a', '2'};
    final int range = solution.compress(input);
    assertArrayEquals(expected, input, range);
  }

  private static void assertArrayEquals(final char[] expected, final char[] actual, final int
      range) {
    assert expected.length == range;
    for (int i = 0; i < range; i++) {
      assert expected[i] == actual[i];
    }
  }
}
