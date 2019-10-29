package interviews.oracle._555_Split_Concatenated_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 10/28/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"abc", "xyz"};
    assertEquals("zyxcba", solution.splitLoopedString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"aaa", "aaa"};
    assertEquals("aaaaaa", solution.splitLoopedString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String[] input = {"awef", "eawf", "zdaeff", "awefzewaf", "awefzewaf"};
    //                    "fewafwaeffeadzfawezfewafawezfewa"
    assertEquals("zfewafewafwaezdaefffawezfewafawe", solution.splitLoopedString(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String[] input = {"lc", "evol", "cdy"};
    //                    "ydclclove"
    assertEquals("ylclovecd", solution.splitLoopedString(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}