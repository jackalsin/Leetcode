package _0501_0550._546_Remove_Boxes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    //                  0 , 1, 2, 3, 4, 5, 6, 7, 8
    final int[] input = {1, 3, 2, 2, 2, 3, 4, 3, 1};
    assertEquals(23, solution.removeBoxes(input));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}