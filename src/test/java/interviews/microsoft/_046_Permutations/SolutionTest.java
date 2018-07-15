package interviews.microsoft._046_Permutations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
  void testWithSingleElement() {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.permute(new int[]{1}));
  }

  @Test
  void testWithMultipleElements() {
    final Set<List<Integer>> expected = new HashSet<>();
    expected.add(Arrays.asList(1, 2, 3));
    expected.add(Arrays.asList(1, 3, 2));
    expected.add(Arrays.asList(2, 1, 3));
    expected.add(Arrays.asList(2, 3, 1));
    expected.add(Arrays.asList(3, 1, 2));
    expected.add(Arrays.asList(3, 2, 1));

    List<List<Integer>> actual = solution.permute(new int[]{1, 2, 3});
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));

  }

  @Test
  void testWithEmptyArray() {
    assertEquals(new ArrayList<>(), solution.permute(new int[]{}));
  }


}