package hulu._002_Add_Two_Numbers;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/8/2020
 */
class SolutionITest {

  private static final ListNode NUM_432 = ListNodes.getListOfNodes(2, 3, 4);

  private static final ListNode NUM_768 = ListNodes.getListOfNodes(8, 6, 7);

  private static final ListNode NUM_38 = ListNodes.getListOfNodes(8, 3);

  @ParameterizedTest
  @MethodSource("solutionStream")
  void addTwoNumbers(Solution solution) {
    assertEquals(ListNodes.getListOfNodes(0, 0, 2, 1),
        solution.addTwoNumbers(NUM_432, NUM_768));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void addTwoNumbers2(Solution solution) {
    final ListNode expected = ListNodes.getListOfNodes(0, 7, 4),
        actual = solution.addTwoNumbers(NUM_432, NUM_38);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
//        new InplaceCalculationSolution()
    );
  }
}