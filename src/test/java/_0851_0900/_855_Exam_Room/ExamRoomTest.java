package _0851_0900._855_Exam_Room;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/22/2019.
 */
class ExamRoomTest {

  @Test
  void testOnlineCase1() {
//    Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//    Output: [null,0,9,4,2,null,5]
//    Explanation:
//    ExamRoom(10) -> null
//    seat() -> 0, no one is in the room, then the student sits at seat number 0.
//    seat() -> 9, the student sits at the last seat number 9.
//    seat() -> 4, the student sits at the last seat number 4.
//    seat() -> 2, the student sits at the last seat number 2.
//    leave(4) -> null
//    seat() -> 5, the student sits at the last seat number 5.

    final ExamRoom solution = new ExamRoom(10);
    assertEquals(0, solution.seat());
    assertEquals(9, solution.seat());
    assertEquals(4, solution.seat());
    assertEquals(2, solution.seat());
    solution.leave(4);
    assertEquals(5, solution.seat());

  }
}