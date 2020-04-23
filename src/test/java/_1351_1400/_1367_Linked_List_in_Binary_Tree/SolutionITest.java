package _1351_1400._1367_Linked_List_in_Binary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;
import utils.TreeNode;
import utils.TreeNodes;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 4/22/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(4, 2, 8);
    final TreeNode root = TreeNodes.getTreeLevelOrder(1,
        4, 4,
        null, 2, 2, null,
        1, null, 6, 8, null, null, null, null, 1, 3);
    assertTrue(solution.isSubPath(head, root));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Solution solution) {
    final ListNode head = ListNodes.getListOfNodes(1, 10, 3, 7, 10, 8, 9, 5, 3, 9, 6, 8, 7, 6, 6, 3, 5, 4, 4, 9, 6, 7
        , 9, 6, 9, 4, 9, 9, 7, 1, 5, 5, 10, 4, 4, 10, 7, 7, 2, 4, 5, 5, 2, 7, 5, 8, 6, 10, 2, 10, 1, 1, 6, 1, 8, 4, 7
        , 10, 9, 7, 9, 9, 7, 7, 7, 1, 5, 9, 8, 10, 5, 1, 7, 6, 1, 2, 10, 5, 7, 7, 2, 4, 10, 1, 7, 10, 9, 1, 9, 10, 4,
        4, 1, 2, 1, 1, 3, 2, 6, 9);
    final TreeNode root = TreeNodes.getTreeLevelOrder(4, null, 8, null, 5, null, 7, null, 5, null, 2, 1, 3, null,
        null, null, 6, 8, 9, null, null, null, 3, null, 2, null, 10, null, 7, null, 8, 3, 4, null, null, null, 3, 5,
        1, null, null, null, 3, 1, 7, null, null, null, 4, 7, 7, null, null, 8, 3, null, null, null, 6, 3, 1, null,
        null, null, 1, null, 8, null, 2, 5, 5, null, null, 1, 3, null, null, null, 5, null, 3, 3, 5, null, null, null
        , 7, null, 10, null, 7, null, 6, null, 8, null, 4, null, 10, null, 6, null, 6, 9, 3, null, null, 6, 5, null,
        null, null, 5, null, 2, null, 7, null, 5, null, 4, 8, 2, null, null, null, 2, null, 10, 10, 8, null, null,
        null, 7, null, 2, null, 5, 8, 6, null, null, null, 5, null, 7, null, 3, 4, 5, null, null, null, 4, null, 8,
        null, 8, null, 8, null, 2, null, 5, 2, 9, null, null, null, 2, null, 3, 7, 1, null, null, 10, 1, null, null,
        null, 7, null, 6, null, 6, null, 7, null, 7, null, 4, 4, 2, null, null, 7, 4, null, null, null, 7, null, 3, 7
        , 5, null, null, null, 5, null, 4, null, 9, 5, 2, null, null, null, 4, null, 9, null, 5, null, 5, null, 5,
        null, 2, null, 5, null, 2, null, 5, null, 7, 5, 5, null, null, null, 6, null, 1, null, 7, null, 3, 9, 8, null
        , null, null, 4, null, 7, 4, 8, null, null, 4, 2, null, null, null, 3, 10, 2, null, null, null, 7, null, 10,
        null, 3, null, 1, null, 2, null, 5, null, 9, null, 8, null, 5, null, 9, null, 3, null, 7, null, 10, 5, 2,
        null, null, null, 2, 8, 10, null, null, null, 4, 4, 7, null, null, null, 5, 1, 4, null, null, null, 10, null,
        9, null, 4, null, 9, 6, 5, null, null, null, 7, 5, 4, null, null, null, 8, null, 8, 4, 9, null, null, null, 6
        , 9, 1, null, null, null, 3, 3, 6, null, null, null, 6, null, 7, null, 2, null, 1, null, 8, 2, 9, null, null,
        null, 8, null, 3, null, 1, 9, 1, null, null, null, 2, null, 6, null, 1, null, 6, 3, 9, null, null, null, 10,
        null, 1, null, 9, null, 9, null, 10, null, 2, null, 6, null, 3, null, 7, null, 2, null, 2, null, 2, 9, 5,
        null, null, null, 5, null, 6, null, 6, null, 2, null, 5, 7, 9, null, null, null, 6, 10, 4, null, null, 8, 4,
        null, null, 4, 2, null, null, 4, 7, null, null, 2, 5, null, null, null, 4, 5, 1, null, null, null, 3, null, 1
        , 10, 6, null, null, 3, 2, null, null, null, 6, null, 9, null, 7, null, 5, 8, 5, null, null, null, 5, null, 5
        , 10, 6, null, null, null, 7, null, 1, null, 6, 3, 7, null, null, null, 9, 7, 1, null, null, null, 7, null, 4
        , null, 4, null, 9, null, 4, null, 1, null, 10, null, 1, 10, 10, null, null, null, 6, null, 3, null, 1, null,
        9, null, 7, null, 6, 6, 1, null, null, null, 9, 4, 7, null, null, null, 3, null, 10, null, 4, 3, 3, null,
        null, null, 4, 5, 10, null, null, null, 1, 8, 10, null, null, null, 6, null, 9, null, 10, null, 4, 4, 9, null
        , null, null, 3, null, 3, null, 3, null, 10, null, 10, null, 6, 8, 1, null, null, null, 9, 7, 1, null, null,
        null, 5, null, 3, null, 10, null, 5, null, 9, null, 5, null, 8, null, 6, 3, 2, null, null, null, 8, null, 8,
        3, 9, null, null, null, 9, null, 10, 3, 8, null, null, 6, 6, null, null, null, 6, null, 8, null, 2, null, 9,
        null, 4, null, 6, null, 4, null, 4, null, 6, null, 9, null, 7, null, 10, null, 1, null, 3, null, 6, null, 7,
        null, 4, null, 9, null, 1, null, 3, 8, 10, null, null, null, 2, null, 10, null, 4, null, 8, null, 10, null, 7
        , null, 8, 5, 1, null, null, 9, 3, null, null, 7, 8, null, null, null, 1, null, 1, 5, 4, null, null, null, 1,
        null, 4, 5, 7, null, null, null, 3, null, 6, null, 6, null, 9, null, 4, null, 1, 5, 10, null, null, null, 3,
        null, 7, null, 10, null, 8, null, 9, 2, 5, null, null, null, 3, null, 9, 10, 6, null, null, null, 8, null, 7,
        8, 6, null, null, null, 6, null, 3, null, 5, null, 4, null, 4, null, 9, null, 6, 2, 7, null, null, null, 9,
        null, 6, 1, 9, null, null, null, 4, null, 9, 9, 9, null, null, null, 7, 7, 1, null, null, null, 5, null, 5, 6
        , 10, null, null, null, 4, null, 4, 10, 10, null, null, null, 7, 2, 7, null, null, null, 2, null, 4, null, 5,
        null, 5, 10, 2, null, null, null, 7, 9, 5, null, null, null, 8, null, 6, null, 10, 8, 2, null, null, 8, 10,
        null, null, null, 1, null, 1, null, 6, 5, 1, null, null, 8, 8, null, null, 8, 4, null, null, null, 7, null,
        10, 4, 9, null, null, null, 7, null, 9, null, 9, 1, 7, null, null, 4, 7, null, null, null, 7, null, 1, null,
        5, 8, 9, null, null, 9, 8, null, null, 9, 10, null, null, 4, 5, null, null, 1, 1, null, null, null, 7, null,
        6, null, 1, null, 2, 1, 10, null, null, 2, 5, null, null, 7, 7, null, null, null, 7, null, 2, null, 4, 3, 10,
        null, null, null, 1, null, 7, null, 10, 7, 9, null, null, null, 5, 4, 9, null, null, null, 10, 6, 4, null,
        null, 8, 4, null, null, null, 1, null, 2, null, 1, 8, 1, null, null, null, 3, null, 2, null, 6, null, 9, null
        , 2, 1, 10, null, null, null, 5, null, 8, 2, 1, null, null, null, 2, 3, 10, null, null, null, 8, null, 9,
        null, 5, null, 4, null, 1, 9, 10, null, null, 4, 9, null, null, 3, 5, null, null, null, 6, null, 6, 9, 1,
        null, null, null, 5, null, 2, null, 2, null, 6, null, 1, 7, 9, null, null, null, 6, null, 8, 4, 4, null, null
        , null, 2, null, 10, null, 1, null, 2, null, 9, null, 8, null, 2, null, 1, 10, 4, null, null, null, 10, null,
        8, 3, 2, null, null, null, 10, null, 3, 8, 1, null, null, 5, 3, null, null, null, 6, null, 8, null, 7, 2, 5,
        null, null, 1, 6, null, null, null, 8, null, 6, null, 3, null, 8, null, 9, null, 5, null, 2, null, 9, null, 2
        , 6, 10, null, null, 7, 10, null, null, null, 6, null, 8, null, 7, 7, 4, null, null, null, 3, 5, 2, null,
        null, 10, 4, null, null, null, 4, 4, 3, null, null, null, 5, null, 1, null, 10, null, 10, null, 5, null, 9,
        null, 3, null, 8, null, 3, null, 2, null, 4, 1, 1, null, null, null, 7, 10, 8, null, null, null, 9, 4, 8,
        null, null, 1, 2, null, null, 9, 7, null, null, 5, 8, null, null, null, 9, null, 7, null, 4, null, 4, 5, 3,
        null, null, null, 2, null, 4, 3, 10, null, null, 7, 7, null, null, null, 2, null, 2, 8, 8, null, null, null,
        2, null, 4, null, 5, 8, 4, null, null, null, 9, null, 4, null, 10, null, 4, null, 5, null, 5, null, 1, null,
        5, null, 8, null, 5, null, 5, null, 1, null, 10, null, 9, null, 10, null, 2, null, 7, 5, 9, null, null, null,
        6, 4, 6, null, null, null, 2, null, 10, null, 1, 4, 3, null, null, 7, 8, null, null, null, 3, null, 3, null,
        8, null, 10, null, 6, 6, 10, null, null, null, 1, 8, 5, null, null, 1, 3, null, null, null, 8, null, 9, null,
        10, null, 8, 4, 9, null, null, 10, 1, null, null, null, 2, null, 8, 5, 2, null, null, 8, 6, null, null, null,
        4, null, 7, 10, 1, null, null, null, 3, 3, 3, null, null, null, 3, null, 5, 7, 3, null, null, 10, 9, null,
        null, null, 2, null, 8, null, 10, null, 7, null, 10, null, 3, 9, 10, null, null, null, 6, 4, 9, null, null, 9
        , 3, null, null, null, 7, null, 2, null, 10, null, 10, null, 7, null, 4, 5, 7, null, null, 9, 8, null, null,
        null, 6, 3, 1, null, null, null, 9, null, 7, 4, 4, null, null, null, 6, null, 1, null, 9, null, 9, null, 3, 1
        , 1, null, null, 1, 8, null, null, null, 1, null, 2, null, 7, 4, 6, null, null, null, 1, null, 3, null, 8,
        null, 10, null, 3, null, 10, null, 10, null, 10, null, 10, null, 10, null, 6, null, 7, null, 3, null, 9, null
        , 7, 5, 4, null, null, null, 5, null, 5, 1, 3, null, null, null, 6, 3, 4, null, null, null, 3, 2, 10, null,
        null, 10, 5, null, null, null, 5, 9, 1, null, null, null, 8, null, 7, null, 9, 5, 3, null, null, null, 2,
        null, 7, null, 10, null, 2, 9, 4, null, null, null, 4, 10, 10, null, null, null, 6, 2, 6, null, null, null, 4
        , null, 5, null, 7, null, 7, null, 2, 4, 1, null, null, null, 7, null, 5, 8, 8, null, null, 3, 6, null, null,
        null, 1, null, 5, null, 8, 4, 6, null, null, null, 6, null, 9, null, 4, null, 4, null, 3, null, 2, 6, 9, null
        , null, null, 6, 6, 8, null, null, null, 7, null, 5, null, 5, null, 9, 4, 3, null, null, null, 10, 4, 6, null
        , null, null, 9, null, 3, null, 10, null, 9, null, 1, null, 6, null, 1, null, 4, null, 5, 5, 3, null, null, 7
        , 8, null, null, null, 6, null, 6, null, 5, 9, 4, null, null, null, 9, null, 7, null, 7, 7, 5, null, null,
        null, 7, null, 3, 8, 3, null, null, null, 1, 5, 4, null, null, null, 2, null, 3, null, 4, null, 5, 5, 6, null
        , null, null, 2, null, 2, 7, 9, null, null, 9, 5, null, null, null, 9, null, 9, null, 8, 7, 6, null, null,
        null, 2, null, 9, null, 2, null, 7, 6, 4, null, null, null, 1, null, 7, null, 2, null, 7, null, 3, 9, 2, null
        , null, 4, 5, null, null, null, 3, null, 2, null, 8, 7, 8, null, null, 7, 7, null, null, null, 10, null, 9, 2
        , 7, null, null, 6, 3, null, null, null, 10, null, 5, null, 7, null, 9, null, 3, null, 1, null, 9, null, 2, 5
        , 2, null, null, null, 4, null, 8, null, 6, 10, 10, null, null, 10, 3, null, null, null, 3, null, 1, null, 3,
        null, 8, 3, 2, null, null, null, 5, 2, 8, null, null, 7, 5, null, null, 7, 7, null, null, null, 1, 6, 5, null
        , null, null, 2, null, 4, null, 7, null, 5, null, 3, null, 7, null, 10, null, 10, null, 7, null, 9, null, 5,
        5, 5, null, null, null, 9, null, 4, null, 7, null, 6, null, 2, null, 3, null, 3, 8, 10, null, null, null, 1,
        null, 3, null, 6, null, 10, null, 8, null, 6, 4, 5, null, null, null, 6, null, 3, null, 3, null, 8, 1, 3,
        null, null, 2, 3, null, null, null, 7, null, 10, null, 2, null, 10, null, 2, null, 7, null, 10, 6, 7, null,
        null, 3, 4, null, null, 6, 2, null, null, null, 9, null, 8, null, 7, null, 10, null, 9, 10, 1, null, null,
        null, 5, 1, 10, null, null, 10, 2, null, null, null, 2, 5, 8, null, null, null, 9, 8, 8, null, null, null, 8,
        null, 4, 1, 3, null, null, null, 4, null, 4, null, 9, null, 4, 10, 7, null, null, 10, 4, null, null, 4, 5,
        null, null, 9, 2, null, null, 3, 7, null, null, 8, 7, null, null, null, 5, null, 10, null, 3, null, 8, null,
        3, null, 5, 2, 9, null, null, null, 10, null, 3, null, 10, null, 7, 5, 1, null, null, 2, 4, null, null, null,
        5, null, 2, null, 6, null, 8, null, 9, null, 10, null, 9, null, 6, null, 2, 6, 7, null, null, 2, 7, null,
        null, null, 3, null, 6, 9, 5, null, null, 2, 6, null, null, null, 8, null, 4, null, 8, null, 2, 4, 9, null,
        null, 4, 7, null, null, null, 9, null, 5, null, 3, null, 8, null, 6, null, 5, 7, 4, null, null, 8, 7, null,
        null, null, 9, 1, 2, null, null, null, 9, 6, 7, null, null, null, 8, null, 6, null, 6, 4, 6, null, null, null
        , 3, null, 5, 10, 4, null, null, null, 5, null, 8, null, 8, null, 7, null, 10, 5, 10, null, null, null, 10,
        null, 10, null, 10, 8, 2, null, null, 5, 3, null, null, null, 8, 6, 6, null, null, 10, 8, null, null, 1, 8,
        null, null, null, 9, 1, 6, null, null, 7, 6, null, null, null, 10, 5, 4, null, null, null, 10, 5, 4, null,
        null, 2, 5, null, null, null, 4, 2, 5, null, null, null, 3, null, 4, 2, 8, null, null, null, 5, null, 9, null
        , 3, 9, 3, null, null, null, 5, null, 7, null, 7, null, 5, null, 10, null, 3, 2, 7, null, null, 3, 8, null,
        null, null, 10, 2, 3, null, null, null, 7, 3, 3, null, null, null, 6, null, 4, null, 8, null, 3, null, 3,
        null, 1, null, 9, 10, 1, null, null, null, 1, null, 6, 6, 5, null, null, 6, 3, null, null, null, 6, null, 4,
        null, 2, null, 10, null, 9, 2, 5, null, null, null, 10, null, 10, 3, 5, null, null, 10, 6, null, null, 1, 9,
        null, null, 6, 7, null, null, 6, 5, null, null, null, 8, null, 8, 5, 6, null, null, null, 6, null, 8, null, 8
        , null, 4, null, 6, null, 9, null, 2, null, 1, null, 10, null, 9, null, 9, null, 4, 1, 6, null, null, null, 1
        , null, 3, null, 4, 10, 8, null, null, null, 7, null, 5, null, 10, null, 1, null, 9, null, 9, null, 9, 1, 8,
        null, null, null, 1, null, 9, 5, 1, null, null, 7, 1, null, null, null, 8, null, 1, 8, 6, null, null, 2, 9,
        null, null, 10, 5, null, null, null, 2, null, 10, null, 10, null, 9, null, 10, null, 7, null, 7, null, 5,
        null, 8, 8, 2, null, null, null, 9, null, 10, null, 1, null, 1, null, 1, null, 10, 6, 1, null, null, null, 9,
        null, 2, 9, 9, null, null, null, 9, 3, 8, null, null, null, 1, null, 10, 1, 10, null, null, null, 8, null, 7,
        null, 8, null, 8, 6, 5, null, null, 2, 5, null, null, null, 7, null, 1, null, 10, null, 4, 8, 5, null, null,
        5, 2, null, null, 2, 3, null, null, null, 6, 3, 10, null, null, 1, 8, null, null, null, 9, null, 8, 7, 10,
        null, null, null, 10, null, 5, 10, 6, null, null, null, 5, null, 6, null, 5, 6, 6, null, null, 5, 8, null,
        null, null, 7, null, 8, null, 10, 1, 1, null, null, null, 10, 1, 2, null, null, 9, 5, null, null, null, 7, 4,
        5, null, null, null, 10, null, 3, null, 5, null, 8, null, 2, null, 9, null, 9, 6, 7, null, null, 7, 1, null,
        null, null, 5, null, 2, null, 8, 5, 3, null, null, null, 7, null, 6, null, 6, null, 7, null, 5, null, 1, 6, 7
        , null, null, null, 6, null, 8, null, 8, null, 5, 10, 10, null, null, null, 10, 5, 2, null, null, 6, 5, null,
        null, 8, 1, null, null, 2, 3, null, null, 9, 3, null, null, 10, 7, null, null, 1, 4, null, null, 5, 10, null,
        null, null, 7, null, 6, null, 1, null, 9, null, 8, null, 2, 10, 7, null, null, null, 5, 3, 9, null, null,
        null, 2, null, 7, null, 3, null, 7, null, 7, 9, 2, null, null, null, 5, null, 6, 1, 2, null, null, 5, 10,
        null, null, 6, 9, null, null, null, 10, 9, 8, null, null, 5, 9, null, null, null, 10, 5, 6, null, null, null,
        10, 10, 1, null, null, null, 7, null, 10, null, 3, null, 2, null, 6, 9, 9, null, null, 2, 5, null, null, null
        , 1, null, 8, null, 2, null, 4, 2, 9, null, null, null, 10, null, 6, null, 5, 2, 3, null, null, null, 1, null
        , 7, null, 10, 6, 10, null, null, null, 2, 5, 9, null, null, 4, 7, null, null, null, 2, 1, 1, null, null,
        null, 9, null, 5, 7, 7, null, null, null, 3, null, 4, null, 10, 2, 6, null, null, 8, 6, null, null, 1, 10,
        null, null, null, 10, 4, 4, null, null, null, 7, null, 8, 7, 5, null, null, null, 2, 10, 6, null, null, 3, 6,
        null, null, null, 10, null, 8, null, 8, 8, 9, null, null, null, 7, null, 8, null, 1, null, 5, null, 8, null,
        7, 10, 6, null, null, null, 3, null, 5, null, 6, 9, 10, null, null, null, 10, null, 6, null, 2, null, 2, null
        , 2, null, 9, null, 7, null, 4, 5, 9, null, null, null, 4, null, 4, null, 3, null, 10, null, 3, 10, 3, null,
        null, 5, 7, null, null, null, 6, null, 3, 3, 4, null, null, null, 7, null, 6, null, 10, null, 5, 8, 8, null,
        null, null, 4, 5, 5, null, null, null, 2, null, 10, null, 2, null, 1, 2, 8, null, null, null, 5, null, 8,
        null, 3, null, 4, null, 8, null, 1, null, 5, 8, 1, null, null, 3, 9, null, null, null, 3, 1, 1, null, null, 5
        , 9, null, null, null, 6, null, 9, 5, 6, null, null, null, 5, 3, 5, null, null, null, 9, 3, 1, null, null, 3,
        5, null, null, 3, 10, null, null, null, 10, null, 8, null, 1, null, 7, null, 4, null, 1, null, 7, null, 1,
        null, 3, 7, 9, null, null, 1, 2, null, null, null, 8, 3, 7, null, null, null, 8, null, 1, 6, 6, null, null,
        null, 9, 7, 4, null, null, 6, 10, null, null, 4, 5, null, null, null, 1, null, 7, null, 6, 7, 3, null, null,
        null, 6, null, 9, null, 8, 2, 6, null, null, 6, 8, null, null, 2, 7, null, null, null, 8, null, 8, 7, 5, null
        , null, null, 4, null, 9, 5, 3, null, null, 9, 5, null, null, null, 5, null, 1, null, 5, null, 6, 8, 6, null,
        null, null, 5, null, 4, null, 2, 8, 5, null, null, null, 9, null, 5, null, 9, null, 3, null, 5, 9, 3, null,
        null, null, 2, null, 7, null, 8, null, 8, null, 8, null, 10, 7, 2, null, null, null, 6, null, 2, 1, 10, null,
        null, null, 6, null, 8, null, 4, null, 6, 8, 5, null, null, null, 3, null, 1, null, 6, null, 6, null, 2, null
        , 9, 1, 9, null, null, null, 3, null, 7, 4, 7, null, null, 9, 6, null, null, 7, 8, null, null, null, 1, 5, 1,
        null, null, 7, 10, null, null, null, 6, null, 8, 3, 2, null, null, 1, 5, null, null, null, 8, null, 3, null,
        3, 9, 1, null, null, null, 8, null, 1, 3, 5, null, null, null, 9, null, 8, 3, 4, null, null, null, 9, null, 1
        , null, 3, null, 7, null, 3, 5, 1, null, null, null, 4, null, 1, null, 5, null, 1, null, 3, 4, 8, null, null,
        null, 1, 10, 7, null, null, null, 1, null, 9, null, 7, null, 3, null, 10, 6, 9, null, null, null, 3, 6, 8,
        null, null, null, 8, null, 3, null, 4, null, 10, null, 2, 10, 7, null, null, 5, 4, null, null, null, 4, 2, 6,
        null, null, 1, 10, null, null, null, 4, 3, 7, null, null, null, 4, null, 1, null, 6, null, 10, null, 7, 4, 9,
        null, null, null, 10, 9, 4, null, null, null, 6, 5, 9, null, null, null, 7, 1, 7, null, null, null, 4, null,
        4, null, 4, null, 6, 4, 3, null, null, null, 4, null, 5, null, 10, null, 2, null, 1, null, 1, null, 2, null,
        2, 9, 4, null, null, null, 9, null, 9, 9, 4, null, null, null, 5, null, 6, null, 2, null, 3, null, 10, 9, 10,
        null, null, 10, 2, null, null, 3, 9, null, null, null, 9, null, 10, null, 9, null, 3, null, 1, 5, 6, null,
        null, null, 6, null, 2, null, 9, null, 3, null, 9, 9, 3, null, null, 5, 3, null, null, null, 2, null, 3, null
        , 8, null, 2, null, 9, null, 3, null, 4, null, 3, null, 4, null, 8, 6, 7, null, null, null, 6, null, 3, null,
        1, null, 9, 5, 1, null, null, null, 2, null, 7, 4, 7, null, null, null, 2, null, 9, null, 7, null, 10, null,
        6, null, 7, null, 1, null, 4, null, 5, null, 2, null, 7, null, 3, null, 7, null, 4, null, 5, null, 10, null,
        1, null, 9, 9, 8, null, null, 10, 10, null, null, null, 6, 6, 10, null, null, 10, 4, null, null, 4, 6, null,
        null, null, 4, null, 3, null, 5, 4, 8, null, null, null, 5, 6, 3, null, null, 1, 7, null, null, 9, 4, null,
        null, null, 9, 10, 2, null, null, null, 5, null, 6, 2, 5, null, null, null, 10, 5, 1, null, null, null, 8, 2,
        2, null, null, 7, 6, null, null, null, 9, null, 4, null, 4, null, 2, null, 4, null, 8, 1, 10, null, null,
        null, 8, null, 3, null, 1, null, 5, null, 2, null, 9, 8, 5, null, null, 8, 6, null, null, null, 1, null, 6,
        null, 2, 2, 9, null, null, null, 9, 5, 7, null, null, null, 4, null, 5, 4, 5, null, null, 1, 1, null, null, 8
        , 3, null, null, null, 10, 7, 10, null, null, 6, 5, null, null, 6, 3, null, null, 4, 1, null, null, 10, 1,
        null, null, 4, 2, null, null, 6, 3, null, null, null, 2, null, 9, null, 10, 9, 9, null, null, null, 2, null,
        8, null, 8, 6, 2, null, null, 10, 7, null, null, null, 10, 1, 3, null, null, 2, 3, null, null, null, 10, 3, 1
        , null, null, null, 9, null, 4, null, 3, null, 4, null, 7, null, 2, null, 1, null, 9, null, 1, null, 7, null,
        9, null, 7, null, 6, 7, 9, null, null, null, 10, null, 6, 3, 2, null, null, null, 4, null, 4, null, 5, 4, 1,
        null, null, null, 3, null, 3, null, 6, null, 5, null, 4, 10, 5, null, null, 4, 6, null, null, 10, 4, null,
        null, null, 7, null, 10, null, 1, null, 1, 5, 6, null, null, 9, 7, null, null, null, 3, null, 6, null, 8,
        null, 2, null, 4, null, 2, null, 7, null, 8, 3, 10, null, null, null, 6, null, 3, null, 7, null, 4, 2, 3,
        null, null, 1, 9, null, null, 5, 6, null, null, 6, 6, null, null, null, 7, null, 8, 9, 9, null, null, null, 9
        , null, 1, null, 9, null, 5, null, 1, null, 5, 2, 6, null, null, null, 9, 2, 4, null, null, 3, 6, null, null,
        4, 2, null, null, null, 9, null, 6, 3, 3, null, null, null, 7, null, 9, null, 6, 2, 9, null, null, null, 8,
        null, 5, null, 4, null, 7, null, 4, null, 8, null, 5, 3, 2, null, null, null, 1, null, 1, null, 1, null, 1,
        null, 1, null, 1, null, 4, null, 6, 3, 7, null, null, 9, 7, null, null, 9, 2, null, null, null, 4, null, 1,
        null, 5, null, 8, null, 2, 10, 1, null, null, null, 10, null, 1, 2, 7, null, null, null, 5, null, 8, null, 7,
        2, 6, null, null, null, 10, null, 3, null, 7, null, 3, null, 6, 9, 4, null, null, null, 2, null, 8, null, 8,
        null, 1, null, 8, null, 8, null, 9, null, 7, null, 5, 10, 9, null, null, 4, 4, null, null, null, 7, null, 6,
        null, 8, 1, 3, null, null, 9, 3, null, null, 1, 10, null, null, null, 9, 8, 2, null, null, null, 8, null, 4,
        null, 4, 4, 1, null, null, null, 7, null, 8, 1, 9, null, null, null, 10, null, 3, 6, 7, null, null, null, 5,
        5, 2, null, null, null, 4, null, 5, 6, 6, null, null, 7, 7, null, null, 5, 10, null, null, null, 6, 10, 6,
        null, null, null, 2, null, 5, 2, 5, null, null, null, 7, null, 7, null, 7, null, 4, null, 9, null, 4, null, 8
        , null, 1, null, 5, null, 9, 6, 4, null, null, null, 8, 9, 2, null, null, 10, 2, null, null, null, 3, null, 4
        , null, 10, null, 6, null, 10, 2, 9, null, null, 6, 1, null, null, null, 7, 6, 6, null, null, null, 2, null,
        4, null, 10, 8, 9, null, null, null, 7, 3, 9, null, null, 10, 4, null, null, null, 10, null, 6, null, 2, null
        , 5, null, 1, null, 8, 8, 3, null, null, null, 2, 5, 10, null, null, 5, 8, null, null, 3, 10, null, null,
        null, 5, null, 8, null, 5, null, 4, null, 5, 6, 2, null, null, null, 7, null, 5, null, 10, null, 8, 1, 5,
        null, null, null, 1, null, 1, null, 5, null, 9, null, 6, null, 1, null, 5);
    assertFalse(solution.isSubPath(head, root));
  }

  static Stream<Solution> solutionProvider() {
    return Stream.of(
        new SolutionI()
    );
  }
}