package interviews.uber._078_Subsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/17/2018.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testEmpty() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>());
    org.junit.Assert.assertEquals(expected, solution.subsets(new int[0]));
  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> result = List.of(
        List.of(3),
        List.of(1),
        List.of(2),
        List.of(1, 2, 3),
        List.of(1, 3),
        List.of(2, 3),
        List.of(1, 2),
        List.of()
    );
    final List<List<Integer>> actual = solution.subsets(new int[] {1, 2, 3});
    assertEquals(result.size(), actual.size());
    assertEquals(new HashSet<>(result), new HashSet<>(actual));
  }
}
