package _0651_0700._658_Find_K_Closest_Elements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionIITest {
  private Solution solution;

  @BeforeEach
  void setUp() throws Exception {
    solution = new SolutionII();
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

  @Test
  void testOnlineCase3() {
    final int[] arr = {1};
    final int k = 1, x = -1;
    assertEquals(List.of(1), solution.findClosestElements(arr, k, x));
  }

  @Test
  void testOnlineCase4() {
    final int[] arr = {0, 1, 2, 2, 2, 3, 6, 8, 8, 9};
    final int k = 5, x = 9;
    assertEquals(List.of(3, 6, 8, 8, 9), solution.findClosestElements(arr, k, x));
  }
}