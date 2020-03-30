package _0551_0600._552_Student_Attendance_Record_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  static Stream<Solution> solutionProvider() {
    return Stream.of(new Solution());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase2(Solution solution) throws Exception {
    assertEquals(8, solution.checkRecord(2));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase3(Solution solution) {
    assertEquals(19, solution.checkRecord(3));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase4(Solution solution) {
    assertEquals(43, solution.checkRecord(4));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase5(Solution solution) {
    assertEquals(94, solution.checkRecord(5));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase6(Solution solution) {
    assertEquals(200, solution.checkRecord(6));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  public void testOnlineCase100(Solution solution) {
    assertEquals(985598218, solution.checkRecord(100));
  }
}