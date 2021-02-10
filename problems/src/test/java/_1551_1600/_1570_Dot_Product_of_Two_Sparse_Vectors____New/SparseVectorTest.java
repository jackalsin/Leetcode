package _1551_1600._1570_Dot_Product_of_Two_Sparse_Vectors____New;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author zhixi
 * @version 1.0 on 2/9/2021
 */
class SparseVectorTest {

  @Test
  void testOnlineCase1() {
    final int[] nums1 = {0, 1, 0, 0, 0}, nums2 = {0, 0, 0, 0, 2};
    assertEquals(0, new SparseVector(nums1).dotProduct(new SparseVector(nums2)));
  }

  @Test
  void testOnlineCase2() {
    final int[] nums1 = {1, 0, 0, 2, 3}, nums2 = {0, 3, 0, 4, 0};
    assertEquals(8, new SparseVector(nums1).dotProduct(new SparseVector(nums2)));
  }

  @Test
  void testOnlineCase3() {
    final int[] nums1 = {0, 1, 0, 0, 2, 0, 0}, nums2 = {1, 0, 0, 0, 3, 0, 4};
    assertEquals(6, new SparseVector(nums1).dotProduct(new SparseVector(nums2)));
  }
}