package airbnb._385_Mini_Parser;

import definition.nestedInteger._385_Mini_Parser.NestedInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/7/2019.
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final String s = "[123,[456,[789]]]";
    final NestedInteger i789 = new NestedInteger();
    i789.add(new NestedInteger(789));
    final NestedInteger i456 = new NestedInteger();
    i456.add(new NestedInteger(456));
    i456.add(i789);
    final NestedInteger i123 = new NestedInteger();
    i123.add(new NestedInteger(123));
    i123.add(i456);
    assertEquals(i123, solution.deserialize(s));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    final String s = "456";
    assertEquals(new NestedInteger(456), solution.deserialize(s));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testFailedOnNegative(Solution solution) {
    final String s = "-456";
    assertEquals(new NestedInteger(-456), solution.deserialize(s));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}