package _0001_0050._030_Substring_With_Concatenation_of_All_Words;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/27.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void findSubstring(Solution solution) {
    assertEquals(List.of(0, 9),
        solution.findSubstring("barfoothefoobarman", new String[]{"bar", "foo"}));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void findSubstringWithDup(Solution solution) {
    assertEquals(Collections.singletonList(8),
        solution.findSubstring("wordgoodgoodgoodbestword",
            new String[]{"word", "good", "best", "good"}));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}