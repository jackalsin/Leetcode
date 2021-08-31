package airbnb._341_Flatten_Nested_List_Iterator;

import definition.nestedInteger.NestedInteger;
import definition.nestedInteger.NestedIntegerImpl;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/3/2019.
 */
class NestedIteratorITest {
  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Class<NestedIterator> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    // [[1,1],2,[1,1]]
    List<NestedInteger> input = List.of(
        new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1)),
        new NestedIntegerImpl(2),
        new NestedIntegerImpl(new NestedIntegerImpl(1), new NestedIntegerImpl(1))
    );
    NestedIterator nestedIterator = solutionClass.getConstructor(List.class).newInstance(input);
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(2), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertTrue(nestedIterator.hasNext());
    assertEquals(Integer.valueOf(1), nestedIterator.next());
    assertFalse(nestedIterator.hasNext());
    assertFalse(nestedIterator.hasNext());
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        NestedIteratorI.class,
        NestedIteratorII.class,
        NestedIteratorIII.class
    );
  }
}