package pureStorage.lockUserAnalyzer;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static pureStorage.lockUserAnalyzer.SolutionI.ACQUIRE;
import static pureStorage.lockUserAnalyzer.SolutionI.RELEASE;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/9/2019
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String[] input = {
        ACQUIRE + " " + 364,
        ACQUIRE + " " + 84,
        RELEASE + " " + 84,
        ACQUIRE + " " + 1337,
        RELEASE + " " + 1337,
        RELEASE + " " + 364,
    };
    assertEquals(0, solution.isValidLockSeq(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String[] input = {
        ACQUIRE + " " + 364,
        ACQUIRE + " " + 84,
        RELEASE + " " + 364,
        RELEASE + " " + 84,
    };
    assertEquals(3, solution.isValidLockSeq(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String[] input = {
        ACQUIRE + " " + 123,
        ACQUIRE + " " + 364,
        ACQUIRE + " " + 84,
        RELEASE + " " + 84,
        RELEASE + " " + 364,
        ACQUIRE + " " + 456,
    };
    assertEquals(7, solution.isValidLockSeq(input));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String[] input = {
        ACQUIRE + " " + 123,
        ACQUIRE + " " + 364,
        ACQUIRE + " " + 84,
        RELEASE + " " + 84,
        RELEASE + " " + 364,
        ACQUIRE + " " + 789,
        RELEASE + " " + 456,
        RELEASE + " " + 123,
    };
    assertEquals(7, solution.isValidLockSeq(input));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}