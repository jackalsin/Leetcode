package lime._732_My_Calendar_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/13/2021
 */
class MyCalendarThreeITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  public void testOnlineCase1(MyCalendarThree myCalendarThree) {
    assertEquals(1, myCalendarThree.book(10, 20));
    assertEquals(1, myCalendarThree.book(50, 60));
    assertEquals(2, myCalendarThree.book(10, 40));
    assertEquals(3, myCalendarThree.book(5, 15));
    assertEquals(3, myCalendarThree.book(5, 10));
    assertEquals(3, myCalendarThree.book(25, 55));
  }

  static Stream<MyCalendarThree> solutionStream() {
    return Stream.of(
        new SegmentTreeNodeSolution()
    );
  }
}