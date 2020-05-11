package _0551_0600._555_Split_Concatenated_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/27/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"abc", "xyz"};
    assertEquals("zyxcba", solution.splitLoopedString(input));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"aaa", "aaa"};
    assertEquals("aaaaaa", solution.splitLoopedString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] input = {"awef", "eawf", "zdaeff", "awefzewaf", "awefzewaf"};
    //                    "fewafwaeffeadzfawezfewafawezfewa"
    assertEquals("zfewafewafwaezdaefffawezfewafawe", solution.splitLoopedString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String[] input = {"lc", "evol", "cdy"};
    //                    "ydclclove"
    assertEquals("ylclovecd", solution.splitLoopedString(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}