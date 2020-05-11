package interviews.linkedin._021_Merge_Two_Sorted_Lists;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 8/2/2019
 */
class SolutionTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    final ListNode l1 = ListNodes.getListOfNodes(new int[]{1, 2, 4}),
        l2 = ListNodes.getListOfNodes(new int[]{1, 3, 4}),
        expected = ListNodes.getListOfNodes(new int[]{1, 1, 2, 3, 4, 4}),
        actual = solution.mergeTwoLists(l1, l2);
    assertEquals(expected, actual);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI(),
        new SolutionII(),
        new SolutionIII()
    );
  }
}
