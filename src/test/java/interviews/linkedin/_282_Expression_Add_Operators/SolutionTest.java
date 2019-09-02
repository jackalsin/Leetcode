package interviews.linkedin._282_Expression_Add_Operators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final String input = "123";
    List<String> actual = solution.addOperators(input, 6);
    Set<String> expect = new HashSet<>() {{
      add("1+2+3");
      add("1*2*3");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final String input = "232";
    List<String> actual = solution.addOperators(input, 8);
    Set<String> expect = new HashSet<String>() {{
      add("2+3*2");
      add("2*3+2");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase3(Solution solution) {
    final String input = "105";
    List<String> actual = solution.addOperators(input, 5);
    Set<String> expect = Set.of("1*0+5", "10-5");
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase4(Solution solution) {
    final String input = "00";
    List<String> actual = solution.addOperators(input, 0);
    Set<String> expect = new HashSet<>() {{
      add("0+0");
      add("0-0");
      add("0*0");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase5(Solution solution) {
    final String input = "3456237490";
    List<String> actual = solution.addOperators(input, 9191);
    Set<String> expect = new HashSet<>();
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase123456789And5(Solution solution) {
    final String input = "123456789";
    final List<String> actual = solution.addOperators(input, 45);
    final Set<String> expect = Set.of(
        "1*2*3*4*5-6-78+9",
        "1*2*3*4+5+6-7+8+9",
        "1*2*3+4+5+6+7+8+9",
        "1*2*3+4+5-6*7+8*9",
        "1*2*3+4-5*6+7*8+9",
        "1*2*3+4-5*6-7+8*9",
        "1*2*3-4*5+6*7+8+9",
        "1*2*3-4*5-6+7*8+9",
        "1*2*3-4*5-6-7+8*9",
        "1*2*3-45+67+8+9",
        "1*2*34+56-7-8*9",
        "1*2*34-5+6-7-8-9",
        "1*2+3*4-56+78+9",
        "1*2+3+4+5*6+7+8-9",
        "1*2+3+4-5+6*7+8-9",
        "1*2+3+4-5-6+7*8-9",
        "1*2+3+45+67-8*9",
        "1*2+3-45+6+7+8*9",
        "1*2+34+5-6-7+8+9",
        "1*2+34+56-7*8+9",
        "1*2+34-5+6+7-8+9",
        "1*2+34-56+7*8+9",
        "1*2+34-56-7+8*9",
        "1*2-3*4+5+67-8-9",
        "1*2-3+4-5-6*7+89",
        "1*2-3-4*5+67+8-9",
        "1*2-3-4+56-7-8+9",
        "1*2-34+5*6+7*8-9",
        "1*23+4*5-6+7-8+9",
        "1*23-4-56-7+89",
        "1+2*3*4*5+6+7-89",
        "1+2*3*4+5*6+7-8-9",
        "1+2*3*4-5+6*7-8-9",
        "1+2*3+4*5*6+7-89",
        "1+2*3+4*5-6+7+8+9",
        "1+2*3-4-5-6*7+89",
        "1+2*34-5*6+7+8-9",
        "1+2+3*4*5+6-7-8-9",
        "1+2+3*4+5+6*7-8-9",
        "1+2+3*45-6-78-9",
        "1+2+3+4+5+6+7+8+9",
        "1+2+3+4+5-6*7+8*9",
        "1+2+3+4-5*6+7*8+9",
        "1+2+3+4-5*6-7+8*9",
        "1+2+3-4*5+6*7+8+9",
        "1+2+3-4*5-6+7*8+9",
        "1+2+3-4*5-6-7+8*9",
        "1+2+3-45+67+8+9",
        "1+2-3*4*5+6+7+89",
        "1+2-3*4+5*6+7+8+9",
        "1+2-3*4-5+6*7+8+9",
        "1+2-3*4-5-6+7*8+9",
        "1+2-3*4-5-6-7+8*9",
        "1+2-3+4*5+6*7-8-9",
        "1+2-3+45+6-7-8+9",
        "1+2-3+45-6+7+8-9",
        "1+2-3-4-5*6+7+8*9",
        "1+2-3-45-6+7+89",
        "1+2-34+5+6+7*8+9",
        "1+2-34+5+6-7+8*9",
        "1+2-34-5-6+78+9",
        "1+23*4+5-6-7*8+9",
        "1+23*4-5-6*7+8-9",
        "1+23*4-56+7-8+9",
        "1+23+4+5+6+7+8-9",
        "1+23+4-5*6+7*8-9",
        "1+23+4-5-67+89",
        "1+23-4*5+6*7+8-9",
        "1+23-4*5-6+7*8-9",
        "1+23-4-5+6+7+8+9",
        "1+23-4-5-6*7+8*9",
        "1+23-45+67+8-9",
        "1-2*3*4+5-6+78-9",
        "1-2*3*4-5-6+7+8*9",
        "1-2*3+4*5+6+7+8+9",
        "1-2*3+4*5-6*7+8*9",
        "1-2*3+4+5+6*7+8-9",
        "1-2*3+4+5-6+7*8-9",
        "1-2*3+4+56+7-8-9",
        "1-2*3+45-67+8*9",
        "1-2*3-4+5*6+7+8+9",
        "1-2*3-4-5+6*7+8+9",
        "1-2*3-4-5-6+7*8+9",
        "1-2*3-4-5-6-7+8*9",
        "1-2*34+5*6-7+89",
        "1-2+3*4*5-6-7+8-9",
        "1-2+3+4-5*6+78-9",
        "1-2+3+45+6-7+8-9",
        "1-2+3-4*5-6+78-9",
        "1-2+3-45+6-7+89",
        "1-2-3*4+5+6+7*8-9",
        "1-2-3*4-5-6+78-9",
        "1-2-3+4-5+67-8-9",
        "1-2-3+45-6-7+8+9",
        "1-2-34+5+6+78-9",
        "1-2-34+56+7+8+9",
        "1-2-34-5+6+7+8*9",
        "1-23*4+5+6*7+89",
        "1-23+4*5-6*7+89",
        "1-23+4-5+67-8+9",
        "1-23+45-67+89",
        "1-23-4+5+67+8-9",
        "1-23-4-5-6-7+89",
        "12*3*4-5*6-78+9",
        "12*3+4+5+6-7-8+9",
        "12*3+4+5-6+7+8-9",
        "12*3-4-5-6+7+8+9",
        "12*3-4-56+78-9",
        "12+3*4+5+6-7+8+9",
        "12+3*45-6-7-89",
        "12+3+4-56-7+89",
        "12+3-4*5+67-8-9",
        "12+3-45+6+78-9",
        "12+34-5-6-7+8+9",
        "12-3*4*5+6+78+9",
        "12-3*4-5+67-8-9",
        "12-3+4*5+6-7+8+9",
        "12-3+4+56-7-8-9",
        "12-3-4+5*6-7+8+9",
        "12-3-4-56+7+89",
        "12-3-45-6+78+9"
    );
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase6(Solution solution) {
    final String input = "2147483648";
    List<String> actual = solution.addOperators(input, -2147483648);
    Set<String> expect = Set.of();
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII(),
        new SolutionIV(),
        new SolutionV(),
        new SolutionVI()
    );
  }
}