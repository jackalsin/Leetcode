package airbnb.listOfListIterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 2/26/2019.
 */
class SolutionTest {

  @Test
  void testOnlineSample() {
    // key thought: Arrays.asList is different from ArrayList<>(), it uses its own ArrayList<>();
    final List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
    final Iterator<Integer> itr = input.iterator();
    assertTrue(itr.hasNext());
    assertEquals(1, (int) itr.next());
    assertTrue(itr.hasNext());
    assertEquals(2, (int) itr.next());
    itr.remove();
    assertEquals(3, (int) itr.next());

    final List<Integer> expected = List.of(1, 3);
    assertEquals(expected, input);

  }

  @Test
  void testOnlineCase1() {
    final List<List<Integer>> input = new ArrayList<>() {{
      add(new ArrayList<>(List.of(1, 2)));
      add(new ArrayList<>(List.of(3)));
      add(new ArrayList<>(List.of(4, 5, 6)));
    }};

    Solution sol = new Solution(input);
    assertTrue(sol.hasNext());
    assertEquals(1, (int) sol.next());
    sol.remove();
    List<Integer> res = new ArrayList<>();
    while (sol.hasNext()) {
      res.add(sol.next());
    }
    assertEquals(5, res.size());
    assertEquals(2, (int) res.get(0));
    assertEquals(4, (int) res.get(2));
    assertEquals(6, (int) res.get(4));

  }

  @Test
  void testOnlineCase2() {
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
    List<Integer> list2 = new ArrayList<>(Arrays.asList(3));
    List<List<Integer>> input = new ArrayList<>();
    input.add(list1);
    input.add(list2);
    final Solution sol = new Solution(input);
    assertTrue(sol.hasNext());
    assertEquals(1, (int) sol.next());
    sol.remove();
    assertTrue(sol.hasNext());
    assertEquals(2, (int) sol.next());
    sol.remove();
    assertTrue(sol.hasNext());
    assertEquals(3, (int) sol.next());
    sol.remove();
    assertEquals(List.of(List.of(), List.of()), input);
  }

  @Test
  void testNullList() {
    List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
    List<Integer> list2 = new ArrayList<>(Arrays.asList(null, 3)); // null element
    final List<List<Integer>> input = new ArrayList<>();
    input.add(list1);
    input.add(null); // null list
    input.add(list2);
    final Solution sol = new Solution(input);
    assertTrue(sol.hasNext());
    assertEquals(1, (int) sol.next());
    assertTrue(sol.hasNext());
    sol.remove();
    assertEquals(2, (int) sol.next());
    assertTrue(sol.hasNext());
    assertNull(sol.next());
    assertEquals(3, (int) sol.next());
  }

  @Test
  void testArrayListNullable() {
    final List<Integer> list = new ArrayList<>();
    Integer i = null;
    list.add(i);
    for (Integer e : list) {
      System.out.println(e);
    }

    list.add(null);
  }


}