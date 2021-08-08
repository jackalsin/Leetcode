package _1301_1350._1312_Minimum_Insertion_Steps_to_Make_a_String_Palindrome;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Solution solution) {
    final String s = "zzazz";
    assertEquals(0, solution.minInsertions(s));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String s = "mbadm";
    assertEquals(2, solution.minInsertions(s));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String s = "leetcode";
    assertEquals(5, solution.minInsertions(s));
//    Explanation: Inserting 5 characters the string becomes "leetcodocteel".
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String s = "g";
    assertEquals(0, solution.minInsertions(s));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String s = "no";
    assertEquals(1, solution.minInsertions(s));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new TopDownSolution(),
        new BottomUpPreArraySolution(),
        new BottomUpPreValSolution()
    );
  }
}
