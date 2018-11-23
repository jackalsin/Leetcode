package _0701_0750._732_My_Calendar_III;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/4/2018.
 */
public class MyCalendarThreeTest {
  @Test
  public void testOnlineCase1() throws Exception {
    final MyCalendarThree myCalendarThree = new MyCalendarThree();
    assertEquals(1, myCalendarThree.book(10, 20));
    assertEquals(1, myCalendarThree.book(50, 60));
    assertEquals(2, myCalendarThree.book(10, 40));
    assertEquals(3, myCalendarThree.book(5, 15));
    assertEquals(3, myCalendarThree.book(5, 10));
    assertEquals(3, myCalendarThree.book(25, 55));
  }
}
