package _0251_0300._251_Flatten_2D_Vector;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/25/2017.
 */
public class Vector2DStephenTest {
  private Vector2DStephen vector2D;

  @BeforeEach
  public void setUp() throws Exception {
  }

  @Test
  public void testOnline() throws Exception {
    final List<List<Integer>> input = new ArrayList<>();
    input.add(Arrays.asList(1, 2));
    input.add(new ArrayList<>());
    input.add(Arrays.asList(3));
    input.add(Arrays.asList(4, 5, 6));
    vector2D = new Vector2DStephen(input);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }

  @Test
  public void testEmpty() throws Exception {
    final List<List<Integer>> input = new ArrayList<>();
    vector2D = new Vector2DStephen(input);

    final List<Integer> expected = Collections.emptyList();
    final List<Integer> actual = new ArrayList<>();
    while (vector2D.hasNext()) {
      actual.add(vector2D.next());
    }

    assertEquals(expected, actual);
  }
}
