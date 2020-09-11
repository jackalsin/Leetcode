package _0851_0900._854_K_Similar_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String A = "ab", B = "ba";
    assertEquals(1, solution.kSimilarity(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String A = "abc", B = "bca";
    assertEquals(2, solution.kSimilarity(A, B));

  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String A = "abac", B = "baca";
    assertEquals(2, solution.kSimilarity(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String A = "aabc", B = "abca";
    assertEquals(2, solution.kSimilarity(A, B));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testTLE(Solution solution) {
    final String A = "cdebcdeadedaaaebfbcf", B = "baaddacfedebefdabecc";
    assertEquals(12, solution.kSimilarity(A, B));
  }

}