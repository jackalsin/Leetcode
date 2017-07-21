package _151_200._160_Intersection_of_Two_Linked_Lists;

import org.junit.Before;
import org.junit.Test;
import utils.ListNode;
import utils.ListNodes;

import static org.junit.Assert.*;

public class SolutionTest {
    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test
    public void testOnlineCase() throws Exception {
        ListNode headA = ListNodes.getListOfNodes(new int[] {1, 2, 3, 4, 5});
        ListNode headB = ListNodes.getListOfNodes(new int[] {-1, -2, -3});
        headB.next.next.next = headA.next.next;
        assertEquals(headA.next.next, solution.getIntersectionNode(headA, headB));
    }

}