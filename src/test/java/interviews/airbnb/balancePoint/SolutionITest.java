package interviews.airbnb.balancePoint;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new SolutionI();
  }

  @Test
  void testMultipleBalancePoint() {
    final int[] input = {0, 0, 0, 0, 0};
    final List<Integer> expected = List.of(0, 1, 2, 3, 4),
        actual = solution.getBalancePoints(input);
    assertEquals(expected, actual);
  }

  @Test
  void testSingleBalancePoint() {
    final int[] input = {1, 1, 1, 1, 1};
    final List<Integer> expected = List.of(2),
        actual = solution.getBalancePoints(input);
    assertEquals(expected, actual);
  }

  @Test
  void testNoBalancePoint() {
    final int[] input = {1, 1, 1, 1};
    final List<Integer> expected = Collections.emptyList(),
        actual = solution.getBalancePoints(input);
    assertEquals(expected, actual);
  }

  @Test
  void testEmptyList() {
    final int[] input = {};
    final List<Integer> expected = Collections.emptyList(),
        actual = solution.getBalancePoints(input);
    assertEquals(expected, actual);
  }

  @Test
  void testSingletonList() {
    final int[] input = {1};
    final List<Integer> expected = List.of(0),
        actual = solution.getBalancePoints(input);
    assertEquals(expected, actual);
  }
}