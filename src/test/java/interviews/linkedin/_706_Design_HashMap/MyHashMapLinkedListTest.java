package interviews.linkedin._706_Design_HashMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapLinkedListTest {
  @Test
  void testOnlineCase1() {
    Solution hashMap = new MyHashMapLinkedList();
    hashMap.put(1, 1);
    hashMap.put(2, 2);
    assertEquals(1, hashMap.get(1));            // returns 1
    assertEquals(-1, hashMap.get(3));            // returns -1 (not found)
    hashMap.put(2, 1);          // update the existing value
    assertEquals(1, hashMap.get(2));            // returns 1
    assertEquals(1, hashMap.remove(2));          // remove the mapping for 2
    assertEquals(-1, hashMap.get(2));            // returns -1 (not found)
  }

  @Test
  void testOnlineCase2() {
//    ["MyHashMap","remove","get","put","put","put","get","put","put","put","put"]
//[[],[14],[4],[7,3],[11,1],[12,1],[7],[1,19],[0,3],[1,8],[2,6]]
    Solution hashMap = new MyHashMapLinkedList();
    hashMap.remove(14);
    assertEquals(-1, hashMap.get(4));            // returns 1
    hashMap.put(7, 3);
    hashMap.put(11, 1);
    hashMap.put(12, 1);
    assertEquals(3, hashMap.get(7));
    hashMap.put(1, 19);
    hashMap.put(0, 3);
    hashMap.put(1, 8);
    hashMap.put(2, 6);


  }
}