package interviews.linkedin._012_Integer_to_Roman;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith1(Solution solution) throws Exception {
    assertEquals("I", solution.intToRoman(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith2(Solution solution) throws Exception {
    assertEquals("II", solution.intToRoman(2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith3(Solution solution) throws Exception {
    assertEquals("III", solution.intToRoman(3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith4(Solution solution) throws Exception {
    assertEquals("IV", solution.intToRoman(4));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith5(Solution solution) throws Exception {
    assertEquals("V", solution.intToRoman(5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith6(Solution solution) throws Exception {
    assertEquals("VI", solution.intToRoman(6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith9(Solution solution) throws Exception {
    assertEquals("IX", solution.intToRoman(9));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith10(Solution solution) throws Exception {
    assertEquals("X", solution.intToRoman(10));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith13(Solution solution) throws Exception {
    assertEquals("XIII", solution.intToRoman(13));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith43(Solution solution) throws Exception {
    assertEquals("XLIII", solution.intToRoman(43));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith333(Solution solution) throws Exception {
    assertEquals("CCCXXXIII", solution.intToRoman(333));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testIntToRomanWith433(Solution solution) throws Exception {
    assertEquals("CDXXXIII", solution.intToRoman(433));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}