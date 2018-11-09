package _601_650._632_Smallest_Range;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TreeSetSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new TreeSetSolution();
  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> input = List.of(
        List.of(4, 10, 15, 24, 26),
        List.of(0, 9, 12, 20),
        List.of(5, 18, 22, 30)
    );
    final int[] actual = solution.smallestRange(input),
        expected = {20, 24};
    assertArrayEquals(expected, actual);
  }
}