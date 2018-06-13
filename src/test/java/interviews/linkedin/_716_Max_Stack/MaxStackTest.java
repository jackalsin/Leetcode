package interviews.linkedin._716_Max_Stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxStackTest {
  private MaxStack maxStack;

  @BeforeEach
  void setUp() {
    maxStack = new MaxStack();
  }

  @Test
  void testOnlineCase1() {
    maxStack.push(5);
    maxStack.push(1);
    maxStack.push(5);
    assertEquals(5, maxStack.top());
    assertEquals(5, maxStack.popMax());
    assertEquals(1, maxStack.top());
    assertEquals(5, maxStack.peekMax());
    assertEquals(1, maxStack.pop());
    assertEquals(5, maxStack.pop());
  }

  @Test
  void testOnlineCase2() {
//    ["MaxStack","push","push","push","peekMax","popMax","popMax","top"]
//    [[],[5],[1],[6],[],[],[],[]]
    maxStack.push(5);
    maxStack.push(1);
    maxStack.push(6);
    assertEquals(6, maxStack.peekMax());
    assertEquals(6, maxStack.popMax());
    assertEquals(5, maxStack.popMax());
    assertEquals(1, maxStack.top());
  }

  @Test
  void testOnlineCase3() {
//    ["MaxStack","push","push","push","peekMax","popMax","popMax","top"]
//    [[],[5],[1],[6],[],[],[],[]]
    maxStack.push(5);
    maxStack.push(5);
    assertEquals(5, maxStack.popMax());
    assertEquals(5, maxStack.popMax());
  }
}