package _001_050._047_Permutations_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 2/26/17.
 */
class SwapSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SwapSolution();
  }

  @Test
  void testWithUnique() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1, 2, 3));
    expected.add(Arrays.asList(1, 3, 2));
    expected.add(Arrays.asList(2, 1, 3));
    expected.add(Arrays.asList(2, 3, 1));
    expected.add(Arrays.asList(3, 1, 2));
    expected.add(Arrays.asList(3, 2, 1));

    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 2, 3});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testWithDupTwice() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1, 1, 2));
    expected.add(Arrays.asList(1, 2, 1));
    expected.add(Arrays.asList(2, 1, 1));

    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 2, 1});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @Test
  void testWithDupMultiple() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1, 1, 1, 2));
    expected.add(Arrays.asList(1, 1, 2, 1));
    expected.add(Arrays.asList(1, 2, 1, 1));
    expected.add(Arrays.asList(2, 1, 1, 1));

    final List<List<Integer>> actual = solution.permuteUnique(new int[]{1, 2, 1, 1});
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

}