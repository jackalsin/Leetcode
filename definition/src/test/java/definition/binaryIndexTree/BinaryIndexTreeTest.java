package definition.binaryIndexTree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author jacka
 * @version 1.0 on 9/16/2017.
 */
public class BinaryIndexTreeTest {
  private BinaryIndexTree binaryIndexTree;
  private static final int[] INPUT_1 = new int[] {2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9};

  /* The first one is */
  private static final int[] TREE_EXPECTED_1 = new int[] {0, 2, 3, 1, 7, 2, 5, 4, 21, 6, 13, 8, 30};
  private static final int[] INPUT_2 = {1, 0, 2, 1, 1, 3, 0, 4, 2, 5, 2, 2, 3, 1, 0, 2};
  private static final int[] TREE_EXPECTED_2 = {0, 1, 1, 2, 4, 1, 4, 0, 12, 2, 7, 2, 11, 3, 4, 0,
      29};

  @Before
  public void setUp() throws Exception {

  }

  @Test
  public void testInputArray() throws Exception {
    testBuilder(INPUT_1, TREE_EXPECTED_1);
    testBuilder(INPUT_2, TREE_EXPECTED_2);
  }

  private void testBuilder(final int[] input, final int[] expectedArray) {
    binaryIndexTree = new BinaryIndexTree(input);
    assertArrayEquals(expectedArray, binaryIndexTree.getTrees());
  }


}
