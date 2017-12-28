package _651_700._658_Find_K_Closest_Elements;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class NLogNSolutionTest {
  private Solution solution;

  @Before
  public void setUp() throws Exception {
    solution = new NLogNSolution();
  }

  @Test
  public void testOnlineCase1() throws Exception {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = 3;
    assertEquals(List.of(1, 2, 3, 4), solution.findClosestElements(arr, k, x));
  }

  @Test
  public void testOnlineCase2() throws Exception {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = -1;
    assertEquals(List.of(1, 2, 3, 4), solution.findClosestElements(arr, k, x));
  }
}
