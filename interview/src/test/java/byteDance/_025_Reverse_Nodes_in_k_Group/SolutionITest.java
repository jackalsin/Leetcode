package byteDance._025_Reverse_Nodes_in_k_Group;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/5/2020
 */
class SolutionITest {
  private final int[] ARRAY = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithK1(Solution solution) {
    final ListNode rtnHead = ListNodes.getListOfNodes(ARRAY);
    assertEquals(ListNodes.getListOfNodes(ARRAY), solution.reverseKGroup(rtnHead, 1));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testWithK3(Solution solution) {
    final ListNode stdHead = ListNodes.getListOfNodes(3, 2, 1, 6, 5, 4, 9, 8, 7);
    final ListNode rtnHead = ListNodes.getListOfNodes(ARRAY);
    assertEquals(stdHead, solution.reverseKGroup(rtnHead, 3));
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}