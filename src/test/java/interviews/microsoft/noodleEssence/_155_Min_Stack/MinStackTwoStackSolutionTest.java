package interviews.microsoft.noodleEssence._155_Min_Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MinStackTwoStackSolutionTest {

  @Test
  void testFailedCase1() {
    //    ["MinStack","push","push","push","getMin","pop","getMin"]
    //[[],[0],[1],[0],[],[],[]]
    final MinStack stack = new MinStackTwoStackSolution();
    stack.push(0);
    stack.push(1);
    stack.push(0);
    assertEquals(0, stack.getMin());
    stack.pop();
    assertEquals(0, stack.getMin());
  }

}