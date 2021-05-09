package google._1055_Shortest_Way_to_Form_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/8/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String source = "abc", target = "abcbc";
    assertEquals(2, solution.shortestWay(source, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String source = "abc", target = "acdbc";
    assertEquals(-1, solution.shortestWay(source, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String source = "xyz", target = "xzyxz";
    assertEquals(3, solution.shortestWay(source, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTEL1(Solution solution) {
    final String source = "lkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlze",
        target =
            "lkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlzelkynjisqcrfkkhrrwwgdnzziupubqchukdinntwiesphyryfsgkjtngabsnzwlze";
    assertEquals(5, solution.shortestWay(source, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String source = "aaaaa",
        target = "aaaaaaaaaaaaa";
    assertEquals(3, solution.shortestWay(source, target));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}