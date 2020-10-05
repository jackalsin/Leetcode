package _0851_0900._884_Uncommon_Words_from_Two_Sentences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String A = "this apple is sweet", B = "this apple is sour";
    final String[] actual = solution.uncommonFromSentences(A, B);
    final Set<String> expected = Set.of(
        "sweet", "sour"
    ), actualCmp = Arrays.stream(actual).collect(Collectors.toSet());
    assertEquals(expected.size(), actual.length);
    assertEquals(expected, actualCmp);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String A = "apple apple", B = "banana";
    final String[] actual = solution.uncommonFromSentences(A, B);
    final Set<String> expected = Set.of(
        "banana"
    ), actualCmp = Arrays.stream(actual).collect(Collectors.toSet());
    assertEquals(expected.size(), actual.length);
    assertEquals(expected, actualCmp);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}