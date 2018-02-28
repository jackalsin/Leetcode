package _651_700._699_Falling_Squares;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/6/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
//    solution = new SegmentTreeSolution();
    solution = new SegmentTreeLazyPropagationSolution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] input = {{1, 2}, {2, 3}, {6, 1}};
    final List<Integer> expected = List.of(2, 5, 5);
    final List<Integer> actual = solution.fallingSquares(input);
    assertEquals(expected, actual);
  }

  @Test
  void testFailedCase1() {
    final int[][] input = {{2, 1}, {2, 9}, {1, 8}};
    final List<Integer> expected = List.of(1, 10, 18);
    final List<Integer> actual = solution.fallingSquares(input);
    assertEquals(expected, actual);
  }

}
