package interviews.hulu._415_Add_Strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 12/18/2019
 */
class DoubleSolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    assertEquals("0", solution.addStrings("0", "0"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase0And0Point0(Solution solution) {
    assertEquals("0.0", solution.addStrings("0.0", "0"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5Point3And3Point7(Solution solution) {
    assertEquals("9", solution.addStrings("5.3", "3.7"));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5Point3And3Point2(Solution solution) {
    assertEquals("8.5", solution.addStrings("5.3", "3.2"));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new DoubleSolution()
    );
  }
}