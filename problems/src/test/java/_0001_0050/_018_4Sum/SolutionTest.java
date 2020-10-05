package _0001_0050._018_4Sum;

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
 * @version 1.0 on 2017/1/21.
 */
public class SolutionTest {
  private static final int[] FOUR_ELEM = new int[]{1, 2, 3, 4};
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith4Elements() throws Exception {
    final List<List<Integer>> sampleAns = new ArrayList<>();
    sampleAns.add(Arrays.asList(1, 2, 3, 4));
    assertEquals(sampleAns, solution.fourSum(FOUR_ELEM, 10));
  }

  @Test
  public void testWithDup() throws Exception {
    final Set<List<Integer>> sampleAns = new HashSet<>();
    sampleAns.add(Arrays.asList(-2, -1, 1, 2));
    sampleAns.add(Arrays.asList(-2, 0, 0, 2));
    sampleAns.add(Arrays.asList(-1, 0, 0, 1));
    assertEquals(sampleAns,
        new HashSet<>(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)));
  }

  @Test
  public void testWithSecondDup() throws Exception {
    final Set<List<Integer>> sampleAns = new HashSet<>();
    sampleAns.add(Arrays.asList(-3, -2, 2, 3)); // [],[],[],[]
    sampleAns.add(Arrays.asList(-3, -1, 1, 3));
    sampleAns.add(Arrays.asList(-3, 0, 0, 3));
    sampleAns.add(Arrays.asList(-3, 0, 1, 2));
    sampleAns.add(Arrays.asList(-2, -1, 0, 3));
    sampleAns.add(Arrays.asList(-2, -1, 1, 2));
    sampleAns.add(Arrays.asList(-2, 0, 0, 2));
    sampleAns.add(Arrays.asList(-1, 0, 0, 1));
    final List<List<Integer>> actualAns =
        solution.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    assertEquals(sampleAns, new HashSet<>(actualAns));
    assertEquals(sampleAns.size(), actualAns.size());
  }

  @Test
  public void testWithFailedCase() throws Exception {
    final Set<List<Integer>> sampleAns = new HashSet<>();
    final List<List<Integer>> actualAns = solution.fourSum(new int[]{-1, 0, 1, 2, -1, -4}, -1);
    sampleAns.add(Arrays.asList(-4, 0, 1, 2));
    sampleAns.add(Arrays.asList(-1, -1, 0, 1));
    assertEquals(sampleAns, new HashSet<>(actualAns));

  }
}