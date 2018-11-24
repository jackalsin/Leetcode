package _0051_0100._078_subset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution2();
  }

  @Test
  void testWith3() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>());
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(2));
    expected.add(Arrays.asList(3));
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(1, 3));
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(1, 2, 3));

//    assertEquals(expected, solution.subsets(new int[] {1, 2, 3}));
  }

  @Test
  void testWithEmpty() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>());
    assertEquals(expected, solution.subsets(new int[]{}));
  }

}