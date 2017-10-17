package interviews.linkedin._047_Permutations_II;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/17/2017.
 */
public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase() throws Exception {
    final Set<List<Integer>> expected =
        Set.of(List.of(1, 1, 2), List.of(1, 2, 1),
            List.of(2, 1, 1));
    final int[] input = {1, 1, 2};
    assertEquals(expected, new HashSet<>(solution.permuteUnique(input)));
  }

}
