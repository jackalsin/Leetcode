package _0351_0400._368_Largest_Divisible_Subset;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class SolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] input = new int[]{1, 2, 3};
    Set<Set<Integer>> expected = Set.of(Set.of(1, 2), Set.of(1, 3));
    List<Integer> actual = solution.largestDivisibleSubset(input);
    System.out.println(actual);
    assertTrue(expected.contains(new HashSet<>(actual)));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] input = new int[]{1, 2, 4, 8};
    Set<Set<Integer>> expected = Set.of(Set.of(1, 2, 4, 8));
    assertTrue(expected.contains(new HashSet<>(solution.largestDivisibleSubset(input))));
  }

  @Test
  public void testFailedCase1() throws Exception {
    final int[] input = new int[]{1};
    Set<Set<Integer>> expected = Set.of(Set.of(1));
    assertTrue(expected.contains(new HashSet<>(solution.largestDivisibleSubset(input))));
  }
}