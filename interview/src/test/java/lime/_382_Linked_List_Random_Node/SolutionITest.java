package lime._382_Linked_List_Random_Node;

import definition.ListNode;
import definition.ListNodes;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 4/7/2021
 */
class SolutionITest {
  private static final double BIAS = 1e-2;

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3);
    final Solution solution = solutionClass.getConstructor(ListNode.class).newInstance(head);
    final int total = 1_000_000;
    final int[] counts = new int[4];
    for (int i = 0; i < total; ++i) {
      counts[solution.getRandom()]++;
    }
    for (int i = 1; i < 4; ++i) {
      assertEquals(1d / 3, counts[i] / (double) total, BIAS);
    }
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final ListNode head = ListNodes.getListOfNodes(10, 1, 10, 20, 100);
    final Solution solution = solutionClass.getConstructor(ListNode.class).newInstance(head);
    final int total = 1_000_000;
    final Map<Integer, Integer> counts = new HashMap<>();
    for (int i = 0; i < total; ++i) {
      final int res = solution.getRandom();
      counts.put(res, counts.getOrDefault(res, 0) + 1);
    }
    System.out.println(counts);
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SolutionI.class
    );
  }
}