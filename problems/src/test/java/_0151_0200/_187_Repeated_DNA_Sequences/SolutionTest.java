package _0151_0200._187_Repeated_DNA_Sequences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/3/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final String source = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    final List<String> expected = Arrays.asList("AAAAACCCCC", "CCCCCAAAAA");
    assertEquals(expected, solution.findRepeatedDnaSequences(source));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test10Chars(Solution solution) {
    final String source = "AAAAAAAAAAA";
    final List<String> expected = Arrays.asList("AAAAAAAAAA");
    assertEquals(expected, solution.findRepeatedDnaSequences(source));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new Solution()
    );
  }
}
