package airbnb._040_Combination_Sum_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/19/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testWithOnlineCase() {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(1, 7));
    expect.add(Arrays.asList(1, 2, 5));
    expect.add(Arrays.asList(2, 6));
    expect.add(Arrays.asList(1, 1, 6));
    List<List<Integer>> actual = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());

  }

  @Test
  void testWithTripleElements() {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(1, 1, 6));
    List<List<Integer>> actual = solution.combinationSum2(new int[]{1, 1, 1, 6, 10}, 8);
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());

  }
}