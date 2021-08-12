package example.unionFind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author jacka
 * @version 1.0 on 10/11/2017.
 */
public class WeightedQuickUnionTest {
  private UnionFind uf;

  @BeforeEach
  public void setUp() throws Exception {
    uf = new WeightedQuickUnion(10);
  }

  @Test
  public void testUnion() throws Exception {
    uf.union(1, 2);
    uf.union(1, 9);
    uf.union(0, 5);
    uf.union(5, 6);
    uf.union(3, 4);
    uf.union(9, 7);
    uf.union(7, 8);
    uf.union(8, 2);

    assertTrue(uf.connected(8, 1));
  }

}
