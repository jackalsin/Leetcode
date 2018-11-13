package _701_750._710_Random_Pick_with_Blacklist;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchSolutionTest {
  private static final int MAX_COUNT = 10_000_000;
  private static final double BIAS = 1E-3;

  @Test
  void testOnlineCase1() {
    final int N = 4, blacklists[] = {};
    final Solution solution = new BinarySearchSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    for (int i = 0; i < N; ++i) {
      assertEquals(0.25, counts[i] / (double) MAX_COUNT, BIAS);
    }
  }

  @Test
  void testOnlineCase2() {
    final int N = 3, blacklists[] = {1};
    final Solution solution = new BinarySearchSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    assertEquals(0.5d, counts[0] / (double) MAX_COUNT, BIAS);
    assertEquals(0.5d, counts[2] / (double) MAX_COUNT, BIAS);
  }

  @Test
  void testOnlineCase3() {
    final int N = 4, blacklists[] = {2};
    final Solution solution = new BinarySearchSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    assertEquals(1 / 3d, counts[0] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 3d, counts[1] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 3d, counts[3] / (double) MAX_COUNT, BIAS);
  }

  @Test
  void testOnlineCase4() {
    final int N = 3, blacklists[] = {0};
    final Solution solution = new BinarySearchSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    assertEquals(1 / 2d, counts[1] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 2d, counts[2] / (double) MAX_COUNT, BIAS);
  }

  @Test
  void testOnlineCase5() {
    final int N = 4, blacklists[] = {0, 1};
    final Solution solution = new BinarySearchSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    System.out.println(Arrays.toString(counts));
    assertEquals(1 / 2d, counts[2] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 2d, counts[3] / (double) MAX_COUNT, BIAS);
  }
}