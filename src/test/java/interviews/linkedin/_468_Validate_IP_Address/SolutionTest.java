package interviews.linkedin._468_Validate_IP_Address;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String ipv4 = "172.16.254.1";
    assertEquals(Solution.IPV4, solution.validIPAddress(ipv4));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseIPv4Leading0(Solution solution) {
    final String ip = "172.16.254.01";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseIPv4Contains0(Solution solution) {
    final String ip = "172.0.0.1";
    assertEquals(Solution.IPV4, solution.validIPAddress(ip));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseIPv4TrailingDot(Solution solution) {
    final String ip = "172.16.254.1.";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseIPv6(Solution solution) {
    final String ip = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
    assertEquals(Solution.IPV6, solution.validIPAddress(ip));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseIPv6Non4HexDigit(Solution solution) {
    final String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334";
    assertEquals(Solution.IPV6, solution.validIPAddress(ip));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCaseIPv6Extra0(Solution solution) {
    final String ip = "02001:0db8:85a3:0000:0000:8a2e:0370:7334";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedCase1IPv6(Solution solution) {
    final String ip = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
    assertEquals(Solution.NEITHER, solution.validIPAddress(ip));
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }

}