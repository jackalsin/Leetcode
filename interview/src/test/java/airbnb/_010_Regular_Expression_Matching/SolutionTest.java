package airbnb._010_Regular_Expression_Matching;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchWithEmptyString(Solution solution) {
    assertTrue(solution.isMatch("", ""));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchWithSameString(Solution solution) {
    assertTrue(solution.isMatch("abc", "abc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchWithAsteriskZeroLength(Solution solution) {
    assertTrue(solution.isMatch("abc", "a*bc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchWithAsteriskMoreThanOneLength(Solution solution) {
    assertTrue(solution.isMatch("aaabc", "a*bc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchWithDot(Solution solution) {
    assertTrue(solution.isMatch("aabc", ".*bc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchWithSingleDot(Solution solution) {
    assertTrue(solution.isMatch("aebc", "a.bc"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchCaseOne(Solution solution) {
    assertTrue(solution.isMatch("aaa", "ab*ac*a"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void isMatchCaseTwo(Solution solution) {
    assertTrue(solution.isMatch("aaa", "ab*a*c*a"));
  }

}