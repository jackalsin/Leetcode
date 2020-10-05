package pinterest._443_String_Compression;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final char[] input = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
    final char[] expected = {'a', '2', 'b', '2', 'c', '3'};
    final int range = solution.compress(input);
    assertArrayEquals(expected, input, range);
  }

  @Test
  void testOnlineCase2() {
    final char[] input = {'a'};
    final char[] expected = {'a'};
    final int range = solution.compress(input);
    assertArrayEquals(expected, input, range);
  }

  @Test
  void testOnlineCase3() {
    final char[] input = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
    final char[] expected = {'a', 'b', '1', '2'};
    final int range = solution.compress(input);
    assertArrayEquals(expected, input, range);
  }

  /**
   * This one fails when we didn't update the target character.
   */
  @Test
  void testFailedOnNotUpdateChar() {
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