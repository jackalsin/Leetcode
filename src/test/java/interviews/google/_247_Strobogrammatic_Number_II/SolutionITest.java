package interviews.google._247_Strobogrammatic_Number_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1(Solution solution) {
    final List<String> expected = Arrays.asList("0", "1", "8");
    final List<String> actual = solution.findStrobogrammatic(1);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test2(Solution solution) {
    final List<String> expected = Arrays.asList("11", "69", "88", "96");
    final List<String> actual = solution.findStrobogrammatic(2);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test3(Solution solution) {
    final List<String> expected = Arrays.asList("101", "111", "181", "609", "619", "689", "808", "818", "888", "906",
        "916", "986");
    final List<String> actual = solution.findStrobogrammatic(3);
    assertEquals(expected.size(), actual.size());
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}