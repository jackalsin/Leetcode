package interviews.linkedin._716_Max_Stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxStackTest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MaxStack maxStack) {
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(MaxStack maxStack) {
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

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(MaxStack maxStack) {
//    ["MaxStack","push","push","push","peekMax","popMax","popMax","top"]
//    [[],[5],[1],[6],[],[],[],[]]
    maxStack.push(5);
    maxStack.push(5);
    assertEquals(5, maxStack.popMax());
    assertEquals(5, maxStack.popMax());
  }

  static Stream<MaxStack> solutionStream() {
    return Stream.of(
        new MaxStackI(),
        new MaxStackII(),
        new MaxStackIII(),
        new MaxStackIV(),
        new MaxStackV(),
        new MaxStackVI()
    );
  }
}