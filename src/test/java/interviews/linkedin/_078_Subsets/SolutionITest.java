package interviews.linkedin._078_Subsets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {
  private Solution solution;

  @BeforeEach
  void setup() {
    solution = new SolutionI();
  }

  @Test
  void testOnlineCase1() {
    final int[] nums = {1, 2, 3};
    final Set<List<Integer>> expected = Set.of(
        List.of(),
        List.of(1),
        List.of(2),
        List.of(3),
        List.of(1, 2),
        List.of(1, 3),
        List.of(2, 3),
        List.of(1, 2, 3)
    );

    final List<List<Integer>> actual = solution.subsets(nums);
    assertEquals(expected.size(), actual.size());
    assertEquals(expected, new HashSet<>(actual));
  }
}