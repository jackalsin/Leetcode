package _001_050._040_Combination_Sum_II;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/18/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWithOnlineCase() throws Exception {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(1, 7));
    expect.add(Arrays.asList(1, 2, 5));
    expect.add(Arrays.asList(2, 6));
    expect.add(Arrays.asList(1, 1, 6));

    List<List<Integer>> actual = solution.combinationSum(new int[] {10, 1, 2, 7, 6, 1, 5}, 8);
    System.out.println("acutal:\n " + actual);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));

  }

  @Test
  public void testWithTripleElements() throws Exception {
    List<List<Integer>> expect = new ArrayList<>();
    expect.add(Arrays.asList(1, 1, 6));

    List<List<Integer>> actual = solution.combinationSum(new int[] {1, 1, 1, 6, 10}, 8);
    System.out.println("acutal:\n " + actual);
    assertEquals(expect.size(), actual.size());
    assertEquals(new HashSet<>(expect), new HashSet<>(actual));

  }
}