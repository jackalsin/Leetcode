package _451_500._468_Validate_IP_Address;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
  private Solution solution;

  @BeforeEach
  void setUp() {
    solution = new Solution();
  }

  @Test
  void testOnlineCase1() {
    final String ipv4 = "172.16.254.1";
    assertEquals(Solution.IPV4, solution.validIPAddress(ipv4));
  }

  @Test
  void testOnlineCaseIPv4Leading0() {
    final String ip = "172.16.254.01";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }

  @Test
  void testOnlineCaseIPv6() {
    final String ip = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
    assertEquals(Solution.IPV6, solution.validIPAddress(ip));
  }

  @Test
  void testOnlineCaseIPv6Extra0() {
    final String ip = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }

  @Test
  void testFailedCase1IPv6() {
    final String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }
}