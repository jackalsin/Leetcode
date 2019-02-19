package interviews.airbnb._216_Combination_Sum_III;

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
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void test3And7() throws Exception {
    List<List<Integer>> expected = new ArrayList<>();
    expected.add(Arrays.asList(1, 2, 4));
    assertEquals(expected, solution.combinationSum3(3, 7));
  }

  @Test
  void test3And9() throws Exception {
    List<List<Integer>> expected = List.of(
        List.of(1, 2, 6),
        List.of(1, 3, 5),
        List.of(2, 3, 4)
    ), actual = solution.combinationSum3(3, 9);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }
}