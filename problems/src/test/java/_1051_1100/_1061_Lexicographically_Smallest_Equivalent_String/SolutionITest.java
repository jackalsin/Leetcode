package _1051_1100._1061_Lexicographically_Smallest_Equivalent_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 11/15/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String A = "parker", B = "morris", S = "parser";
    assertEquals("makkek", solution.smallestEquivalentString(A, B, S));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String A = "hello", B = "world", S = "hold";
    assertEquals("hdld", solution.smallestEquivalentString(A, B, S));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String A = "leetcode", B = "programs", S = "sourcecode";
    assertEquals("aauaaaaada", solution.smallestEquivalentString(A, B, S));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String
        A = "dfeffdfafbbebbebacbbdfcfdbcacdcbeeffdfebbdebbdafff",
        B = "adcdfabadbeeafeabbadcefcaabdecabfecffbabbfcdfcaaae",
        S = "myickvflcpfyqievitqtwvfpsrxigauvlqdtqhpfugguwfcpqv";
    assertEquals("myiakvalapayqiavitqtwvapsrxigauvlqatqhpaugguwaapqv", solution.smallestEquivalentString(A, B, S));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}