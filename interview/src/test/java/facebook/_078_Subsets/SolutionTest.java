package facebook._078_Subsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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
  void testWith3() {
    final Set<List<Integer>> expected = new HashSet<>();
    expected.add(new ArrayList<>());
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(2));
    expected.add(Arrays.asList(3));
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(1, 3));
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(1, 2, 3));

    assertEquals(expected, new HashSet<>(solution.subsets(new int[]{1, 2, 3})));
  }

  @Test
  void testWithEmpty() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>());
    assertEquals(expected, solution.subsets(new int[]{}));
  }

}