package interviews.oracle._394_Decode_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline1(Solution solution) {
    assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline2(Solution solution) {
    assertEquals("accaccacc", solution.decodeString("3[a2[c]]"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnline3(Solution solution) {
    assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}