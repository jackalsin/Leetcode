package oracle._839_Similar_String_Groups;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/9/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = {"tars", "rats", "arts", "star"};
    assertEquals(2, solution.numSimilarGroups(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = {"qihcochwmglyiggvsqqfgjjxu", "gcgqxiysqfqugmjgwclhjhovi", "gjhoggxvcqlcsyifmqgqujwhi",
        "wqoijxciuqlyghcvjhgsqfmgg", "qshcoghwmglygqgviiqfjcjxu", "jgcxqfqhuyimjglgihvcqsgow",
        "qshcoghwmggylqgviiqfjcjxu", "wcoijxqiuqlyghcvjhgsqgmgf", "qshcoghwmglyiqgvigqfjcjxu",
        "qgsjggjuiyihlqcxfovchqmwg", "wcoijxjiuqlyghcvqhgsqgmgf", "sijgumvhqwqioclcggxgyhfjq",
        "lhogcgfqqihjuqsyicxgwmvgj", "ijhoggxvcqlcsygfmqgqujwhi", "qshcojhwmglyiqgvigqfgcjxu",
        "wcoijxqiuqlyghcvjhgsqfmgg", "qshcojhwmglyiggviqqfgcjxu", "lhogcgqqfihjuqsyicxgwmvgj",
        "xscjjyfiuglqigmgqwqghcvho", "lhggcgfqqihjuqsyicxgwmvoj", "lhgocgfqqihjuqsyicxgwmvgj",
        "qihcojhwmglyiggvsqqfgcjxu", "ojjycmqshgglwicfqguxvihgq", "sijvumghqwqioclcggxgyhfjq",
        "gglhhifwvqgqcoyumcgjjisqx"};
    assertEquals(11, solution.numSimilarGroups(input));
  }

  @ParameterizedTest
  @MethodSource("provideIsSimilar")
  void testIsSimilar(final boolean expected, final String a, final String b) {
    Assertions.assertEquals(expected, SolutionI.isSimilar(a, b));
  }

  private static Stream<Arguments> provideIsSimilar() {
    return Stream.of(
        // y: {"tars", "rats", "arts"} and {"star"}
        Arguments.of(true, "tars", "rats"),
        Arguments.of(false, "tars", "arts"),
        Arguments.of(false, "tars", "star"),
        Arguments.of(true, "rats", "arts"),
        Arguments.of(false, "rats", "star"),
        Arguments.of(false, "arts", "star")
    );
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}