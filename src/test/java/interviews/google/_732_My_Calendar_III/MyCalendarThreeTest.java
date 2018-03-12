package interviews.google._732_My_Calendar_III;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 3/11/2018.
 */
class MyCalendarThreeTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void testCase1() {
    final MyCalendarThree myCalendarThree = new MyCalendarThree();
    assertEquals(1, myCalendarThree.book(10, 20));
    assertEquals(1, myCalendarThree.book(50, 60));
    assertEquals(2, myCalendarThree.book(10, 40));
    assertEquals(3, myCalendarThree.book(5, 15));
    assertEquals(3, myCalendarThree.book(5, 10));
    assertEquals(3, myCalendarThree.book(25, 55));
  }
}
