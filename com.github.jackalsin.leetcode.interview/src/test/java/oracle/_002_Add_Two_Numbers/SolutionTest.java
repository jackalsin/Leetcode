package oracle._002_Add_Two_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 10/22/2019
 */
class SolutionTest {

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
    assertEquals(ListNodes.getListOfNodes(0, 7, 4),
        solution.addTwoNumbers(NUM_432, NUM_38));
  }


  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}