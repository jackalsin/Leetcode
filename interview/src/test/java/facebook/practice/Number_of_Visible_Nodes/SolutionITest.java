package facebook.practice.Number_of_Visible_Nodes;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 5/2/2021
 */
class SolutionITest {

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase1(Solution solution) {
    //Testcase 1
    int n_1 = 3, q_1 = 1;
    String s_1 = "aba";
    Node root_1 = new Node(1);
    root_1.children.add(new Node(2));
    root_1.children.add(new Node(3));
    ArrayList<Query> queries_1 = new ArrayList<>();
    queries_1.add(new Query(1, 'a'));
    int[] output_1 = solution.countOfNodes(root_1, queries_1, s_1);
    int[] expected_1 = {2};
    assertArrayEquals(expected_1, output_1);
  }

  @ParameterizedTest
  @MethodSource("solutionStream")
  void testOnlineCase2(Solution solution) {
    // Testcase 2
    int n_2 = 7, q_2 = 3;
    String s_2 = "abaacab";
    Node root_2 = new Node(1);
    root_2.children.add(new Node(2));
    root_2.children.add(new Node(3));
    root_2.children.add(new Node(7));
    root_2.children.get(0).children.add(new Node(4));
    root_2.children.get(0).children.add(new Node(5));
    root_2.children.get(1).children.add(new Node(6));
    ArrayList<Query> queries_2 = new ArrayList<>();
    queries_2.add(new Query(1, 'a'));
    queries_2.add(new Query(2, 'b'));
    queries_2.add(new Query(3, 'a'));
    int[] output_2 = solution.countOfNodes(root_2, queries_2, s_2);
    int[] expected_2 = {4, 1, 2};
    assertArrayEquals(expected_2, output_2);
  }

  static Stream<Solution> solutionStream() {
    return Stream.of(
        new SolutionI()
    );
  }
}