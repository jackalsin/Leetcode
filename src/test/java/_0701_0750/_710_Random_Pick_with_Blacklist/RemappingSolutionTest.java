package _0701_0750._710_Random_Pick_with_Blacklist;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class RemappingSolutionTest {
  private static final int MAX_COUNT = 1_000_000;
  private static final double BIAS = 1E-3;

  @Test
  void testOnlineCase1() {
    final int N = 4;
    final int[] blacklists = {};
    final Solution solution = new RemappingSolution(N, blacklists);
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
    final int N = 3;
    final int[] blacklists = {1};
    final Solution solution = new RemappingSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(0.5d, counts[0] / (double) MAX_COUNT, BIAS);
    assertEquals(0.5d, counts[2] / (double) MAX_COUNT, BIAS);
  }

  @Test
  void testOnlineCase3() {
    final int N = 4;
    final int[] blacklists = {2};
    final Solution solution = new RemappingSolution(N, blacklists);
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
    final int N = 3;
    final int[] blacklists = {0};
    final Solution solution = new RemappingSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }

    assertEquals(1 / 2d, counts[1] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 2d, counts[2] / (double) MAX_COUNT, BIAS);
  }

  @Test
  void testOnlineCase5() {
    final int N = 4;
    final int[] blacklists = {0, 1};
    final Solution solution = new RemappingSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(1 / 2d, counts[2] / (double) MAX_COUNT, BIAS);
    assertEquals(1 / 2d, counts[3] / (double) MAX_COUNT, BIAS);
  }

  @Test
  void testOnlineCase6() {
    final int N = 2;
    final int[] blacklists = {1};
    final Solution solution = new RemappingSolution(N, blacklists);
    final int[] counts = new int[N];
    for (int i = 0; i < MAX_COUNT; ++i) {
      counts[solution.pick()]++;
    }
    assertEquals(1, counts[0] / (double) MAX_COUNT, BIAS);
  }
}