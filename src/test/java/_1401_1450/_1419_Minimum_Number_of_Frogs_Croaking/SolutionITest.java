package _1401_1450._1419_Minimum_Number_of_Frogs_Croaking;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/18/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String croakOfFrogs = "croakcroak";
    final int expected = 1, actual = solution.minNumberOfFrogs(croakOfFrogs);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String croakOfFrogs = "crcoakroak";
    final int expected = 2, actual = solution.minNumberOfFrogs(croakOfFrogs);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String croakOfFrogs = "croakcrook";
    final int expected = -1, actual = solution.minNumberOfFrogs(croakOfFrogs);
    assertEquals(expected, actual);

  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String croakOfFrogs = "croakcroa";
    final int expected = -1, actual = solution.minNumberOfFrogs(croakOfFrogs);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}