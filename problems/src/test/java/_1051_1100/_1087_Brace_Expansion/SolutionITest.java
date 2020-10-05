package _1051_1100._1087_Brace_Expansion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/22/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "{a,b}c{d,e}f";
    final Set<String> expected = Set.of("acdf", "acef", "bcdf", "bcef");
    final String[] actual = solution.expand(input);
    final List<String> actualList = Arrays.stream(actual).collect(Collectors.toList());
    assertEquals(expected, new HashSet<>(actualList));
    assertEquals(expected.size(), actualList.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String input = "abcd";
    final Set<String> expected = Set.of(input);
    final String[] actual = solution.expand(input);
    final List<String> actualList = Arrays.stream(actual).collect(Collectors.toList());
    assertEquals(expected, new HashSet<>(actualList));
    assertEquals(expected.size(), actualList.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "{a,b}{z,x,y}";
    final List<String> expected = List.of("ax", "ay", "az", "bx", "by", "bz");
    final String[] actual = solution.expand(input);
    final List<String> actualList = Arrays.stream(actual).collect(Collectors.toList());
    assertEquals(expected, actualList);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}