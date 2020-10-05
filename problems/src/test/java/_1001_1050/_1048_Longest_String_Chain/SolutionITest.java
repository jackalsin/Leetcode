package _1001_1050._1048_Longest_String_Chain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/2/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"a", "b", "ba", "bca", "bda", "bdca"};
    final int expected = 4;
    assertEquals(expected, solution.longestStrChain(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"cozddh",
        "ferawpnpff", "ivftewfdn", "mq", "zmq", "nwzmbq", "rcozyddh", "rcozyddhm", "czddh", "hrcozyddhm", "vftewfdn",
        "vtefdn", "rpeyrgwm", "wcjaki", "jiddfyh", "nzmbq", "xnvzrzc", "zdh", "utcc", "peyrgwm", "pergwm", "vftefdn",
        "rcozddh", "h", "zddh", "tcc", "nnwhszmbuq", "utgcc", "nnwszmbq", "jiddfh", "zmbq", "ivtftewfdn", "vefdn",
        "ferawpnff", "xnvzrc", "nnwhszmbq", "dh", "nwszmbq"};
    final int expected = 10;
    assertEquals(expected, solution.longestStrChain(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}