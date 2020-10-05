package linkedin._744_Find_Smallest_Letter_Greater_Than_Target;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'a';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'c';
    assertEquals('f', solution.nextGreatestLetter(letters, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'd';
    assertEquals('f', solution.nextGreatestLetter(letters, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'g';
    assertEquals('j', solution.nextGreatestLetter(letters, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'a';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'j';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase7(Solution solution) {
    final char[] letters = {'c', 'f', 'j'};
    final char target = 'k';
    assertEquals('c', solution.nextGreatestLetter(letters, target));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}