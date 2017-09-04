package _251_300._281_Zigzag_Iterator;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 9/3/2017.
 */
public class ZigzagIteratorTest {
  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnline() throws Exception {
    final List<Integer> v1 = Arrays.asList(1, 2);
    final List<Integer> v2 = Arrays.asList(3, 4, 5, 6);
    final ZigzagIterator iterator = new ZigzagIterator(v1, v2);
    final List<Integer> expected = Arrays.asList(1, 3, 2, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();

    while (iterator.hasNext()) {
      actual.add(iterator.next());
    }

    assertEquals(expected, actual);
  }

}
