package airbnb._347_Top_K_Frequent_Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/6/2019.
 */
class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  void testOnlineCase() throws Exception {
    final int[] nums = {1, 1, 1, 2, 2, 3};
    final Set<Integer> expected = Set.of(1, 2);
    final List<Integer> actual = solution.topKFrequent(nums, 2);
    assertEquals(expected, new HashSet<>(actual));
  }
}