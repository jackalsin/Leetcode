package _0201_0250._233_Number_of_Digit_One;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author jacka
 * @version 1.0 on 7/23/2017.
 */
public class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test0(Solution solution) {
    assertEquals(0, solution.countDigitOne(0));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1(Solution solution) {
    assertEquals(1, solution.countDigitOne(1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test13(Solution solution) {
    assertEquals(6, solution.countDigitOne(13));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testNegative1(Solution solution) {
    assertEquals(0, solution.countDigitOne(-1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test23(Solution solution) {
    assertEquals(13, solution.countDigitOne(23));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test20(Solution solution) {
    assertEquals(12, solution.countDigitOne(20));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test12316(Solution solution) {
    assertEquals(8086, solution.countDigitOne(12316));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1615(Solution solution) {
    assertEquals(1144, solution.countDigitOne(1615));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test1410065408(Solution solution) {
    assertEquals(1737167499, solution.countDigitOne(1410065408));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}
