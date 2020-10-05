package _0701_0750._707_Design_Linked_List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
class MyLinkedListITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(MyLinkedList linkedList) {
    linkedList.addAtHead(1);
    linkedList.addAtTail(3);
    linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
    assertEquals(2, linkedList.get(1));            // returns 2
    linkedList.deleteAtIndex(1);  // now the linked list is 1->3
    assertEquals(3, linkedList.get(1));            // returns 3
  }

  static Stream<MyLinkedList> solutionStream() {
    return Stream.of(
        new MyLinkedListI()
    );
  }
}