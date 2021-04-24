package google._282_Expression_Add_Operators;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/24/2021
 */
class SolutionITest {


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String input = "123";
    List<String> actual = solution.addOperators(input, 6);
    Set<String> expect = new HashSet<String>() {{
      add("1+2+3");
      add("1*2*3");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
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
  @MethodSource("solutionStream")
  void testOnlineCase3(Solution solution) {
    final String input = "105";
    List<String> actual = solution.addOperators(input, 5);
    Set<String> expect = new HashSet<String>() {{
      add("1*0+5");
      add("10-5");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Solution solution) {
    final String input = "00";
    List<String> actual = solution.addOperators(input, 0);
    Set<String> expect = new HashSet<String>() {{
      add("0+0");
      add("0-0");
      add("0*0");
    }};
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase5(Solution solution) {
    final String input = "3456237490";
    List<String> actual = solution.addOperators(input, 9191);
    Set<String> expect = new HashSet<String>();
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase6(Solution solution) {
    final String input = "2147483648";
    List<String> actual = solution.addOperators(input, -2147483648);
    Set<String> expect = new HashSet<>();
    assertEquals(expect, new HashSet<>(actual));
    assertEquals(expect.size(), actual.size());
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}