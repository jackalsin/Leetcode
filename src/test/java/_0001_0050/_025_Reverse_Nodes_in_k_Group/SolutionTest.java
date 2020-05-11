package _0001_0050._025_Reverse_Nodes_in_k_Group;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2017/1/24.
 */
public class SolutionTest {

  private final int[] ARRAY = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

  static Stream<Solution> solutionStream() {
    return Stream.of(new Solution());
  }

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
}
