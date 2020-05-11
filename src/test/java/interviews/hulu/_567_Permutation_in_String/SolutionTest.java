package interviews.hulu._567_Permutation_in_String;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 12/19/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    final String s1 = "ab", s2 = "eidbaooo";
    assertTrue(solution.checkInclusion(s1, s2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    final String s1 = "ab", s2 = "eidboaoo";
    assertFalse(solution.checkInclusion(s1, s2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    //                               012345678901
    final String s1 = "hello", s2 = "ooolleoooleh";
    assertFalse(solution.checkInclusion(s1, s2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase4(Solution solution) {
    final String s1 = "adc", s2 = "dcda";
    assertTrue(solution.checkInclusion(s1, s2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testTLE1(Solution solution) {
    final String s1 = "dinitrophenylhydrazine", s2 = "acetylphenylhydrazine";
    assertFalse(solution.checkInclusion(s1, s2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testTLE2(Solution solution) {
    final String s1 =
        "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl" +
            "mnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstu" +
            "vwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd" +
            "efghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg" +
            "hijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghij" +
            "klmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdef",
        s2 = "bcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcde" +
            "fghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghij" +
            "klmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmno" +
            "pqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrst" +
            "uvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxy" +
            "zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg";
    assertFalse(solution.checkInclusion(s1, s2));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}