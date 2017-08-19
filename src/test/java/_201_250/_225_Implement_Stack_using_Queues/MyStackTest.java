package _201_250._225_Implement_Stack_using_Queues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author jacka
 * @version 1.0 on 8/16/2017.
 */
public class MyStackTest {
  private MyStack stack;
  @Before
  public void setUp() throws Exception {
    stack = new MyStack();
  }

  @Test
  public void testFailed1()throws Exception {
    stack.push(1);
    stack.push(2);
    assertEquals(2, stack.top());
  }

}
