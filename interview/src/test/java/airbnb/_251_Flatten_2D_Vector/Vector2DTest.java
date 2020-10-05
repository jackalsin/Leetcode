package airbnb._251_Flatten_2D_Vector;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 1/28/2019.
 */
class Vector2DTest {
  @Test
  void testOnline() throws Exception {
    final int[][] input = new int[][]{
        {1, 2},
        {},
        {3},
        {4, 5, 6}
    };
    Vector2D vector2D = new Vector2D(input);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }

  @Test
  void testEmpty() throws Exception {
    Vector2D vector2D = new Vector2D(new int[][]{});

    final List<Integer> expected = Collections.emptyList();
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }
}