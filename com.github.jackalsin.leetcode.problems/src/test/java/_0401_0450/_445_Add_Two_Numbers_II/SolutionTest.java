package _0401_0450._445_Add_Two_Numbers_II;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.util.stream.Stream;

/**
 * @author jacka
 * @version 1.0 on 10/29/2017.
 */
public class SolutionTest {
  static Stream<Solution> solutionStream() {
    return Stream.of(
        new ReverseSolution(),
        new ReverseResultNotInPlace(),
        new NoReverseSolution()
    );
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test13And22(Solution solution) {
    ListNode l1 = ListNodes.getListOfNodes(1, 3);
    ListNode l2 = ListNodes.getListOfNodes(2, 2);
    assertEquals(ListNodes.getListOfNodes(3, 5), solution.addTwoNumbers(l1, l2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test19And23(Solution solution) {
    ListNode l1 = ListNodes.getListOfNodes(1, 9);
    ListNode l2 = ListNodes.getListOfNodes(2, 3);
    assertEquals(ListNodes.getListOfNodes(4, 2), solution.addTwoNumbers(l1, l2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void test85And77(Solution solution) {
    ListNode l1 = ListNodes.getListOfNodes(8, 5);
    ListNode l2 = ListNodes.getListOfNodes(7, 7);
    assertEquals(ListNodes.getListOfNodes(1, 6, 2), solution.addTwoNumbers(l1, l2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase1And99(Solution solution) {
    ListNode l1 = ListNodes.getListOfNodes(1);
    ListNode l2 = ListNodes.getListOfNodes(9, 9);
    assertEquals(ListNodes.getListOfNodes(1, 0, 0), solution.addTwoNumbers(l1, l2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase99And8(Solution solution) {
    ListNode l1 = ListNodes.getListOfNodes(9, 9);
    ListNode l2 = ListNodes.getListOfNodes(8);
    assertEquals(ListNodes.getListOfNodes(1, 0, 7), solution.addTwoNumbers(l1, l2));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testFailedCase899And2(Solution solution) {
    ListNode l1 = ListNodes.getListOfNodes(8, 9, 9);
    ListNode l2 = ListNodes.getListOfNodes(2);
    assertEquals(ListNodes.getListOfNodes(9, 0, 1), solution.addTwoNumbers(l1, l2));
  }
}
