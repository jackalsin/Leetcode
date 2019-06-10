package interviews.airbnb._251_Flatten_2D_Vector;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenericVector2DTest {

  @Test
  void testOnlineCase1() {
    final Integer[][] input = {
        {1, 2},
        {},
        {3},
        {4, 5, 6}
    };
    final GenericVector2D<Integer> solution = new GenericVector2D<>(input);
    final List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    final List<Integer> actual = new ArrayList<>();
    while (solution.hasNext()) {
      actual.add(solution.next());
    }
    assertEquals(expected, actual);
  }

  @Test
  void testEmpty() {
    final GenericVector2D<Integer> solution = new GenericVector2D<>(new Integer[][]{});
    final List<Integer> expected = Collections.emptyList();
    final List<Integer> actual = new ArrayList<>();
    while (solution.hasNext()) {
      actual.add(solution.next());
    }
    assertEquals(expected, actual);
  }
}