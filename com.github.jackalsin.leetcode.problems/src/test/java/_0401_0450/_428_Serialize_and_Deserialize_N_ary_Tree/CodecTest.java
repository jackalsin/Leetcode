package _0401_0450._428_Serialize_and_Deserialize_N_ary_Tree;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import definition.nAryTree.Node;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {

  @ParameterizedTest
  @MethodSource("solutionStream")
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
  @MethodSource("solutionStream")
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
  @MethodSource("solutionStream")
  void testNull(Codec solution) {
    final Node root = null;
    final String actual = solution.serialize(root);
    assertEquals(root, solution.deserialize(actual));
  }

  static Stream<Codec> solutionStream() {
    return Stream.of(
        new Codec()
    );
  }
}