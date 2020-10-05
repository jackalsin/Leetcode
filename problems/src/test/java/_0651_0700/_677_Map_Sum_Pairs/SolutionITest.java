package _0651_0700._677_Map_Sum_Pairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/14/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MapSum solution) {
    solution.insert("apple", 3);
    assertEquals(3, solution.sum("ap"));
    solution.insert("app", 2);
    assertEquals(5, solution.sum("ap"));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(MapSum solution) {
    solution.insert("aa", 3);
    assertEquals(3, solution.sum("a"));
    solution.insert("aa", 2);
    assertEquals(2, solution.sum("a"));
  }

  static Stream<MapSum> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}