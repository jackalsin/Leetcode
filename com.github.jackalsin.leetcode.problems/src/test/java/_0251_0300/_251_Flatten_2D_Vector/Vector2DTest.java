package _0251_0300._251_Flatten_2D_Vector;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Vector2DTest {
  private Vector2D vector2D;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void testOnline() throws Exception {
    final List<List<Integer>> input = new ArrayList<>();
    input.add(Arrays.asList(1, 2));
    input.add(Arrays.asList(3));
    input.add(Arrays.asList(4, 5, 6));
    vector2D = new Vector2D(input);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }
}
