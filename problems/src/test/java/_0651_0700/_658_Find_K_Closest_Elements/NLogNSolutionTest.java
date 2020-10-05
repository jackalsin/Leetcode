package _0651_0700._658_Find_K_Closest_Elements;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

class NLogNSolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new NLogNSolution();
  }

  @Test
  void testOnlineCase1() throws Exception {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = 3;
    assertEquals(List.of(1, 2, 3, 4), solution.findClosestElements(arr, k, x));
  }

  @Test
  void testOnlineCase2() throws Exception {
    final int[] arr = {1, 2, 3, 4, 5};
    final int k = 4, x = -1;
    assertEquals(List.of(1, 2, 3, 4), solution.findClosestElements(arr, k, x));
  }
}
