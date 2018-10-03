package interviews.linkedin._046_Permutations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIVTest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionIV();
  }

  @Test
  void testOnlineCase1() {
    final int[] input = {1, 2, 3};
    final Set<List<Integer>> expected = Set.of(
        List.of(1, 2, 3),
        List.of(1, 3, 2),
        List.of(2, 1, 3),
        List.of(2, 3, 1),
        List.of(3, 2, 1),
        List.of(3, 1, 2)
    );

    final List<List<Integer>> actual = solution.permute(input);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }
}