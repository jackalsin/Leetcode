package pinterest.sparseVector;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SparseVectorTest {

  @Test
  void testOnlineCase1() {
    SparseVector v = new SparseVector(100); //size constructor; size is 100
    v.set(0, 1.0);
    v.set(3, 2.0);
    v.set(80, -4.5);

    assertEquals(-4.5, v.get(80)); //should print -4.5
    assertEquals(0.0, v.get(50)); //should print 0.0. From 1point 3acres bbs

  }

  @Test
  void testOnlineCase2() {
    SparseVector v = new SparseVector(100); //size constructor; size is 100
    v.set(0, 1.0);
    v.set(3, 2.0);
    v.set(80, -4.5);

    assertThrows(IndexOutOfBoundsException.class, () -> {
      v.get(101);
    });

  }

  @Test
  void testOnlineCase3() {
    SparseVector v = new SparseVector(5); //size constructor; size is 100
    v.set(0, 1.0);
    v.set(3, 2.0);
    final String expected = "[1.0, 0.0, 0.0, 2.0, 0.0]";
    final String actual = v.toString();
    assertEquals(expected, actual);
  }

}