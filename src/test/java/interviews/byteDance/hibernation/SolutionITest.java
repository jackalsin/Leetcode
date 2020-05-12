package interviews.byteDance.hibernation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/10/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    assertEquals(1, solution.get(0));
    assertEquals(1, solution.get(1));
    assertEquals(1, solution.get(2));
    assertEquals(1, solution.get(3));
    assertEquals(2, solution.get(4));
    assertEquals(3, solution.get(5));
    assertEquals(4, solution.get(6));
    assertEquals(5, solution.get(7));
    assertEquals(6, solution.get(8));
    assertEquals(8, solution.get(9));
    assertEquals(11, solution.get(10));
    assertEquals(15, solution.get(11));
    assertEquals(19, solution.get(12));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}