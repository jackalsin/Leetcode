package uber.intervalMerge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] p1 = {
        {1, 2}, {3, 4}, {10, 13}
    }, p2 = {
        {2, 3}, {4, 9},
    };
    final List<List<Integer>> expected = List.of(
        List.of(1, 9), List.of(10, 13)
    ), actual = solution.orOperation(p1, p2);
    assertEquals(expected, actual);
  }
}