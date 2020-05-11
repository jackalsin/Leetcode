package interviews.linkedin._002_Add_Two_Numbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private static final ListNode NUM_432 = ListNodes.getListOfNodes(new int[]{2, 3, 4});

  private static final ListNode NUM_768 = ListNodes.getListOfNodes(new int[]{8, 6, 7});

  private static final ListNode NUM_38 = ListNodes.getListOfNodes(new int[]{8, 3});

  @ParameterizedTest
  @MethodSource("solutionStream")
  void addTwoNumbers(Solution solution) throws Exception {
    assertEquals(ListNodes.getListOfNodes(new int[]{0, 0, 2, 1}),
        solution.addTwoNumbers(NUM_432, NUM_768));
    assertEquals(ListNodes.getListOfNodes(new int[]{0, 7, 4}),
        solution.addTwoNumbers(NUM_432, NUM_38));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII()
    );
  }
}