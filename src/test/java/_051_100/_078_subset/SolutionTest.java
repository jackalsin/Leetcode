package _051_100._078_subset;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/13/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith3() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>());
    expected.add(Arrays.asList(1));
    expected.add(Arrays.asList(2));
    expected.add(Arrays.asList(3));
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(1, 3));
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(1, 2, 3));

//    assertEquals(expected, solution.subsets(new int[] {1, 2, 3}));
  }

  @Test
  public void testWithEmpty() throws Exception {
    final List<List<Integer>> expected = new ArrayList<>();
    expected.add(new ArrayList<>());
    assertEquals(expected,  solution.subsets(new int[] {}));
  }

}