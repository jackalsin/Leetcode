package interviews.oracle._415_Add_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author jacka
 * @version 1.0 on 10/29/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals("0", solution.addStrings("0", "0"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    assertEquals("10", solution.addStrings("1", "9"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    assertEquals("77", solution.addStrings("33", "44"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    assertEquals("114", solution.addStrings("76", "38"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}