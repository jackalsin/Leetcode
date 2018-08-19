package _051_100._090_Subsets_II;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIIITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionIII();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 2, 2};
    final List<List<Integer>> actual = solution.subsetsWithDup(nums);
    System.out.println(actual);
    final Set<List<Integer>> expected = Set.of(
        List.of(),
        List.of(1),
        List.of(1, 2),
        List.of(1, 2, 2),
        List.of(2),
        List.of(2, 2)
    );
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }

}