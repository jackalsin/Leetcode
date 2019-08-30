package interviews.linkedin._187_Repeated_DNA_Sequences;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testAAAAAAAAAAA(Solution solution) {
    final String input = "AAAAAAAAAAA";
    assertEquals(List.of("AAAAAAAAAA"), solution.findRepeatedDnaSequences(input));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testAAAAACCCCCAAAAACCCCCCAAAAAGGGTTT(Solution solution) {
    final String input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    assertEquals(List.of("AAAAACCCCC", "CCCCCAAAAA"), solution.findRepeatedDnaSequences(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV()
    );
  }

}
