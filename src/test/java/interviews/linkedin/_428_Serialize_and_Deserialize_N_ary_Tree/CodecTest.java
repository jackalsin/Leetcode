package interviews.linkedin._428_Serialize_and_Deserialize_N_ary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import utils.treeNode.Node;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhiwei.xin
 * @version 1.0 on 9/14/18
 */
class CodecTest {

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase1(Codec solution) {
    final Node root = new Node();
    root.val = 1;
    root.children = List.of(new Node(3, List.of(
        new Node(5, List.of()), new Node(6, List.of())
    )), new Node(2, List.of()), new Node(4, List.of()));
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testOnlineCase2(Codec solution) {
    final Node root = new Node();
    root.val = 1;
    root.children = List.of(new Node(3, List.of(
        new Node(5, List.of(new Node(6, List.of())))
    )), new Node(2, List.of()), new Node(4, List.of()));
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }

  @ParameterizedTest
  @MethodSource("solutionProvider")
  void testNull(Codec solution) {
    final Node root = null;
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }

  static Stream<Codec> solutionProvider() {
    return Stream.of(
        new CodecI(),
        new CodecII(),
        new CodecIII()
    );
  }
}