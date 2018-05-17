package interviews.pinterest.diaonalsInMatrix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final int[][] board = {
        {1, 2, 3},
        {4, 5, 6}
    };

    final Set<List<Integer>> expected = Set.of(
        List.of(1),
        List.of(4, 2),
        List.of(5, 3),
        List.of(6),
        List.of(4),
        List.of(1, 5),
        List.of(2, 6),
        List.of(3)
    );

    final Set<List<Integer>> actual = new HashSet<>(solution.getDiagnals(board));
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final int[][] board = {
        {1, 2},
        {3, 4},
        {5, 6}
    };

    final Set<List<Integer>> expected = Set.of(
        List.of(5),
        List.of(3, 6),
        List.of(1, 4),
        List.of(2),
        List.of(1),
        List.of(3, 2),
        List.of(5, 4),
        List.of(6)
    );

    final Set<List<Integer>> actual = new HashSet<>(solution.getDiagnals(board));
    assertEquals(expected, actual);
  }
}