package interviews.airbnb.MinimumVerticesToTraverseDirectedGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    ////    1->2->3->1, 2->0->0
    final int[][] input = {
        {1, 0, 0, 0},
        {0, 0, 1, 0},
        {1, 0, 0, 1},
        {0, 1, 0, 0}
    };
    final List<Integer> actual = solution.getMin(input, 4);
    final Set<Integer> expected = Set.of(1, 2, 3);
    assertTrue(expected.contains(actual.get(0)));
    assertEquals(1, actual.size());
  }

  @Test
  void testOnlineCase2() {
    ////    0->1->0, 2->3->2->1
    final int[][] input = {
        {0, 1, 0, 0},
        {1, 0, 0, 0},
        {0, 1, 0, 1},
        {0, 0, 1, 0}
    };
    final List<Integer> actual = solution.getMin(input, 4);
    final Set<List<Integer>> expected = Set.of(
        List.of(0),
        List.of(1),
        List.of(2),
        List.of(3)
    );
    assertTrue(expected.contains(actual));
  }

  @Test
  void testOnlineCase3() {
    ////    3->2->1->0  0->1 3->1
    ////      0  1  2  3
    ////    0[0, 1, 0, 0]
    ////    1[1, 0, 0, 0]
    ////    2[0, 1, 0, 0]
    ////    3[0, 1, 1, 0]
    final int[][] input = {
        {0, 1, 0, 0},
        {1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 1, 1, 0}
    };
    final List<Integer> actual = solution.getMin(input, 4),
        expected = List.of(3);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase4() {
    final int[][] input = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
        {0, 0, 0, 1, 0, 1, 0, 1, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
        {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
        {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
    };
    final List<Integer> actual = solution.getMin(input, 10),
        expected = List.of(0, 1, 2);
    assertEquals(expected, actual);
  }
}