package _1251_1300._1290_Convert_Binary_Number_in_a_Linked_List_to_Integer;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 11/1/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 0, 1);
    assertEquals(5, solution.getDecimalValue(head));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}