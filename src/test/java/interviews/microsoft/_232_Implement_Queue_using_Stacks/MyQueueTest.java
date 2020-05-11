package interviews.microsoft._232_Implement_Queue_using_Stacks;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyQueueTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<MyQueue> myQueueClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    MyQueue queue = myQueueClass.getConstructor().newInstance();
    queue.push(1);
    queue.push(2);
    assertEquals(1, queue.peek());  // returns 1
    assertEquals(1, queue.pop());  // returns 1
    assertFalse(queue.empty()); // returns false
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        MyQueue.class
    );
  }
}