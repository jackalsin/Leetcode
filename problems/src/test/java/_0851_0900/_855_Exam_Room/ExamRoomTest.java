package _0851_0900._855_Exam_Room;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/23/2019.
 */
class ExamRoomTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<ExamRoom> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
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
    final ExamRoom solution = cacheClass.getConstructor(Integer.TYPE).newInstance(10);
    assertEquals(0, solution.seat());
    assertEquals(9, solution.seat());
    assertEquals(4, solution.seat());
    assertEquals(2, solution.seat());
    solution.leave(4);
    assertEquals(5, solution.seat());
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<ExamRoom> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
//    Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
//    Output: [null,0,9,4,2,null,5]
    final ExamRoom solution = cacheClass.getConstructor(Integer.TYPE).newInstance(10);
    assertEquals(0, solution.seat());
    assertEquals(9, solution.seat());
    assertEquals(4, solution.seat());
    solution.leave(0);
    solution.leave(4);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase3(Class<ExamRoom> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final ExamRoom solution = cacheClass.getConstructor(Integer.TYPE).newInstance(8);
    assertEquals(0, solution.seat());
    assertEquals(7, solution.seat());
    assertEquals(3, solution.seat());
    solution.leave(0);
    solution.leave(7);
    assertEquals(7, solution.seat());
    assertEquals(0, solution.seat());
    assertEquals(5, solution.seat());
    assertEquals(1, solution.seat());
    assertEquals(2, solution.seat());
    assertEquals(4, solution.seat());
    assertEquals(6, solution.seat());
  }


  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase4(Class<ExamRoom> cacheClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final ExamRoom solution = cacheClass.getConstructor(Integer.TYPE).newInstance(4);
    //    ["ExamRoom","seat","seat","seat","seat","leave","leave","seat"]
    //    [[4],[],[],[],[],[1],[3],[]]
    //    [null,0,3,1,2,null,null,1]
    assertEquals(0, solution.seat());
    assertEquals(3, solution.seat());
    assertEquals(1, solution.seat());
    assertEquals(2, solution.seat());
    solution.leave(1);
    solution.leave(3);
    assertEquals(1, solution.seat());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        ExamRoomI.class,
        ExamRoomInterval.class,
        ExamRoomII.class
    );
  }
}