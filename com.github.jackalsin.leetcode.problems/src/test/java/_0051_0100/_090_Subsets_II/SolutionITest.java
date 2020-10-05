package _0051_0100._090_Subsets_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/29/2017.
 */
public class SolutionITest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new SolutionI();
  }

  @Test
  public void testOnlineCase() throws Exception {
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