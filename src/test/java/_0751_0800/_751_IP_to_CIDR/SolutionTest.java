package _0751_0800._751_IP_to_CIDR;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String ip = "255.0.0.7";
    final int n = 10;
    final List<String> expected = List.of("255.0.0.7/32", "255.0.0.8/29", "255.0.0.16/32"),
        actual = solution.ipToCIDR(ip, n);
    assertEquals(expected, actual);
  }

  @Test
  void testOnlineCase2() {
    final String ip = "117.145.102.62";
    final int n = 8;
    final List<String> expected = List.of("117.145.102.62/31", "117.145.102.64/30", "117.145.102.68/31"),
        actual = solution.ipToCIDR(ip, n);
    assertEquals(expected, actual);
  }

}