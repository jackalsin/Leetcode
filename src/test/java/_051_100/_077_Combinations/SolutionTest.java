package _051_100._077_Combinations;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/12/2017.
 */
public class SolutionTest {
  private Solution solution;
  @Before
  public void setUp() throws Exception {
    solution = new Solution();
  }

  @Test
  public void testWith4And2() throws Exception {
    Set<List<Integer>> expected = new HashSet<>();
    expected.add(Arrays.asList(1, 2));
    expected.add(Arrays.asList(1, 3));
    expected.add(Arrays.asList(1, 4));
    expected.add(Arrays.asList(2, 3));
    expected.add(Arrays.asList(2, 4));
    expected.add(Arrays.asList(3, 4));
    assertEquals(expected, new HashSet<>(solution.combine(4,2)));
  }

  @Test
  public void testBenchMark() throws Exception {
    final int times = 10_000;
    for (int i = 0; i < times; i++) {
      testWith4And2();
    }
    long startTime = System.nanoTime();
    for (int i = 0; i < times; i++) {
      testWith4And2();
    }
    long endTime = System.nanoTime();
    System.out.println("Copy:");
    System.out.println((endTime - startTime) / times / 1e3);
  }



}