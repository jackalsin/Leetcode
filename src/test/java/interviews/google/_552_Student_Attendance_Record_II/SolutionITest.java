package interviews.google._552_Student_Attendance_Record_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/29/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) throws Exception {
    assertEquals(8, solution.checkRecord(2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    assertEquals(19, solution.checkRecord(3));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase4(Solution solution) {
    assertEquals(43, solution.checkRecord(4));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase5(Solution solution) {
    assertEquals(94, solution.checkRecord(5));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase6(Solution solution) {
    assertEquals(200, solution.checkRecord(6));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase100(Solution solution) {
    assertEquals(985598218, solution.checkRecord(100));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}