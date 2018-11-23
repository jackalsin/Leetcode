package _0601_0650._632_Smallest_Range;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SinglePriorityQueueSolutionTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SinglePriorityQueueSolution();
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
    System.out.println(Arrays.toString(actual));
    assertArrayEquals(expected, actual);
  }

}