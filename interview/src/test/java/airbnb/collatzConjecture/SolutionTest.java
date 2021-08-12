package airbnb.collatzConjecture;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */

class SolutionTest {

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }

  //less than 10 is 9, which has 19 steps,
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(Solution solution) {
    assertEquals(19, solution.findTheLongestStep(10));
  }

  //less than 100 is 97, which has 118 steps,
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase2(Solution solution) {
    assertEquals(118, solution.findTheLongestStep(100));
  }

  //less than 1,000 is 871, which has 178 steps,
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase3(Solution solution) {
    assertEquals(178, solution.findTheLongestStep(1_000));
  }

  //less than 10,000 is 6,171, which has 261 steps,
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase4(Solution solution) {
    assertEquals(261, solution.findTheLongestStep(10_000));
  }

  //less than 100,000 is 77,031, which has 350 steps,
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase5(Solution solution) {
    assertEquals(350, solution.findTheLongestStep(100_000));
  }

  /**
   * This will take 1s 141ms on my local machine
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase6(Solution solution) {
    //less than 1 million is 837,799, which has 524 steps,
    assertEquals(524, solution.findTheLongestStep(1_000_000));
  }

  /**
   * This will take 9s 891ms on my local machine
   */
  @ParameterizedTest
  @MethodSource("solutionStream")
  @Disabled
  public void testOnlineCase7(Solution solution) {
    //less than 10 million is 8,400,511, which has 685 steps,
    assertEquals(685, solution.findTheLongestStep(10_000_000));
  }
}