package interviews.hulu._382_Linked_List_Random_Node;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.ListNode;
import utils.ListNodes;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author jacka
 * @version 1.0 on 2/6/2020
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase(Class<Solution> solutionClass) throws NoSuchMethodException, IllegalAccessException,
      InvocationTargetException, InstantiationException {
    final ListNode head = ListNodes.getListOfNodes(1, 2, 3);
    Solution solution = solutionClass.getConstructor(ListNode.class).newInstance(head);
    final Map<Integer, Integer> prob = new HashMap<>();
    final int total = 10_000_000;
    for (int i = 0; i < total; ++i) {
      final int res = solution.getRandom();
      prob.put(res, prob.getOrDefault(res, 0) + 1);
    }
    for (final Map.Entry<Integer, Integer> e : prob.entrySet()) {
      final double actualP = (double) e.getValue() / total;
      assertEquals(1d / 3, actualP, 1E-3);
    }
  }

  static Stream<Class> solutionStream() {
    return Stream.of(
        SolutionI.class
    );
  }
}