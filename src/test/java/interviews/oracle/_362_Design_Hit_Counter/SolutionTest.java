package interviews.oracle._362_Design_Hit_Counter;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/14/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    // hit at timestamp 1.
    solution.hit(1);
    // hit at timestamp 2.
    solution.hit(2);
    // hit at timestamp 3.
    solution.hit(3);
    // get hits at timestamp 4, should return 3.
    assertEquals(3, solution.getHits(4));
    // hit at timestamp 300.
    solution.hit(300);
    // get hits at timestamp 300, should return 4.
    assertEquals(4, solution.getHits(300));
    // get hits at timestamp 301, should return 3.
    assertEquals(3, solution.getHits(301));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}