package _0901_0950._936_Stamping_The_Sequence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String stamp = "abc", target = "ababc";
    assertArrayEquals(new int[]{0, 2}, solution.movesToStamp(stamp, target));
  }

  @Test
  void testOnlineCase2() {
    final String stamp = "abca", target = "aabcaca";
    assertArrayEquals(new int[]{3, 0, 1}, solution.movesToStamp(stamp, target));
  }
}