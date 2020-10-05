package tableau._273_Integer_to_English_Words;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/13/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testZero(Solution solution) {
    assertEquals("Zero", solution.numberToWords(0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOne(Solution solution) {
    assertEquals("One", solution.numberToWords(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test27(Solution solution) {
    assertEquals("Twenty Seven", solution.numberToWords(27));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test127(Solution solution) {
    assertEquals("One Hundred Twenty Seven", solution.numberToWords(127));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1227(Solution solution) {
    assertEquals("One Thousand Two Hundred Twenty Seven", solution.numberToWords(1227));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test1234567(Solution solution) {
    assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven",
        solution.numberToWords(1234567));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMillion(Solution solution) {
    assertEquals("One Million", solution.numberToWords(1_000_000));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testMillion2Hundred(Solution solution) {
    assertEquals("One Million Two Hundred", solution.numberToWords(1_000_200));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void test20(Solution solution) {
    assertEquals("Twenty", solution.numberToWords(20));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}