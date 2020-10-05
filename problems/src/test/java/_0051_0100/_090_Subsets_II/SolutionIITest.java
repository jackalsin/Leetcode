package _0051_0100._090_Subsets_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionII();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = new int[]{1, 2, 2};
    final Set<List<Integer>> expected = new HashSet<>();
    expected.add(Arrays.asList(2));
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(1, 2, 2));
    expected.add(Arrays.asList(2, 2));
    expected.add(Arrays.asList(1));
    expected.add(new ArrayList<>());
    List<List<Integer>> actual = solution.subsetsWithDup(input);
    assertEquals(expected, new HashSet<>(actual));
  }
}