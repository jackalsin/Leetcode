package _0351_0400._398_Random_Pick_Index;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 1/11/2018.
 */
public class SolutionTest {

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] nums = {1, 2, 3, 3, 3};
    Solution solution = new NaiveSolution(nums);
    assertEquals(0, solution.pick(1));
    assertEquals(1, solution.pick(2));
    assertTrue(Set.of(2, 3, 4).contains(solution.pick(3)));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] nums = {1, 2, 3, 3, 3};
    Solution solution = new ReservoirSampleSolution(nums);
    assertEquals(0, solution.pick(1));
    assertEquals(1, solution.pick(2));
    final int[] counts = new int[5];
    final int COUNT = 300_000;
    final double[] chances = new double[5];
    for (int i = 0; i < COUNT; i++) {
      int res = solution.pick(3);
      counts[res]++;
    }

    for (int i = 0; i < chances.length; i++) {
      chances[i] = (double) counts[i] / COUNT;
    }
    System.out.println(Arrays.toString(chances));
  }
}
