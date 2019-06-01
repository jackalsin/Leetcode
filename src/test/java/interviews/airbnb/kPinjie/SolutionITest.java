package interviews.airbnb.kPinjie;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {1, 2, 3};
    final String expected = "3";
    assertEquals(expected, solution.getBiggestNumWithKSelection(input, 1));
  }

  @Test
  void testOnlineCase2() {
    final int[] input = {1, 2, 3};
    final String expected = "23";
    assertEquals(expected, solution.getBiggestNumWithKSelection(input, 2));
  }

  @Test
  void testOnlineCase3() {
    final int[] input = {1, 2, 3};
    final String expected = "123";
    assertEquals(expected, solution.getBiggestNumWithKSelection(input, 3));
  }

  @Test
  void testOnlineCase4() {
    final int[] input = {3, 2, 3};
    final String expected = "33";
    assertEquals(expected, solution.getBiggestNumWithKSelection(input, 2));
  }

  @Test
  void testOnlineCase5() {
    final int[] input = {33333333, 222222222, 1388923423};
    final String expected = "2222222221388923423";
    assertEquals(expected, solution.getBiggestNumWithKSelection(input, 2));
  }
}