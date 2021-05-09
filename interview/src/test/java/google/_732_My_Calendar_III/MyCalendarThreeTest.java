package google._732_My_Calendar_III;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
class MyCalendarThreeTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testCase1(MyCalendarThree myCalendarThree) {
    assertEquals(1, myCalendarThree.book(10, 20));
    assertEquals(1, myCalendarThree.book(50, 60));
    assertEquals(2, myCalendarThree.book(10, 40));
    assertEquals(3, myCalendarThree.book(5, 15));
    assertEquals(3, myCalendarThree.book(5, 10));
    assertEquals(3, myCalendarThree.book(25, 55));
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testCase2(MyCalendarThree myCalendarThree) {
    assertEquals(1, myCalendarThree.book(499_548_726, 511_410_485));
  }

  static Stream<MyCalendarThree> solutionStream() {
    return Stream.of(
        new MyCalendarThreeI(),
        new MyCalendarThreeII(),
        new MyCalendarThreeIII()
    );
  }
}
