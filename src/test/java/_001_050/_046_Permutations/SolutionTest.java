package _001_050._046_Permutations;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/25/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithSingleElement() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(Collections.singletonList(1));
    assertEquals(expected, solution.permute(new int[]{1}));
  }

  @Test
  public void testWithMultipleElements() throws Exception {
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
  public void testWithEmptyArray() throws Exception {
    assertEquals(new ArrayList<>(), solution.permute(new int[]{}) );
  }

}