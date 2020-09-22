package _0901_0950._925_Long_Pressed_Name;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author zhixi
 * @version 1.0 on 9/21/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String name = "alex", typed = "aaleex";
    assertTrue(solution.isLongPressedName(name, typed));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String name = "leelee", typed = "lleeelee";
    assertTrue(solution.isLongPressedName(name, typed));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String name = "saeed", typed = "ssaaedd";
    assertFalse(solution.isLongPressedName(name, typed));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String name = "laiden", typed = "laiden";
    assertTrue(solution.isLongPressedName(name, typed));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String name = "alex", typed = "alexxr";
    assertFalse(solution.isLongPressedName(name, typed));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}