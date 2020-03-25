package _1051_1100._1096_Brace_Expansion_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/23/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String input = "{a,b}{c,{d,e}}";
    final List<String> expected = List.of("ac", "ad", "ae", "bc", "bd", "be"),
        actual = solution.braceExpansionII(input);
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String input = "{{a,z},a{b,c},{ab,z}}";
    final List<String> expected = List.of("a", "ab", "ac", "z"),
        actual = solution.braceExpansionII(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String input = "{a{b,c},{a,z},{ab,z}}";
    final List<String> expected = List.of("a", "ab", "ac", "z"),
        actual = solution.braceExpansionII(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String input = "a{b,c}";
    final List<String> expected = List.of("ab", "ac"),
        actual = solution.braceExpansionII(input);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}