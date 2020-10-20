package _1001_1050._1023_Camelcase_Matching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String queries[] = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, pattern = "FB";
    final List<Boolean> expected = List.of(true, false, true, true, false), actual = solution.camelMatch(queries,
        pattern);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String queries[] = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, pattern = "FoBa";
    final List<Boolean> expected = List.of(true, false, true, false, false), actual = solution.camelMatch(queries,
        pattern);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String queries[] = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"}, pattern = "FoBaT";
    final List<Boolean> expected = List.of(false, true, false, false, false), actual = solution.camelMatch(queries,
        pattern);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}