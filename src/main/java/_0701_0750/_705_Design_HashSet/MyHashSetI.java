package _0701_0750._705_Design_HashSet;

import java.util.LinkedList;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class MyHashSetI implements MyHashSet {
  private static final int SIZE = 10000;
  private final LinkedList<Integer>[] values = new LinkedList[SIZE];

  public void add(int key) {
    final int i = key % SIZE;
    if (values[i] == null) values[i] = new LinkedList<>();
    if (values[i].contains(key)) return;
    values[i].add(key);
  }

  public void remove(int key) {
    final int i = key % SIZE;
    if (values[i] == null) return;
    values[i].remove((Object) key);
  }

  public boolean contains(int key) {
    final int i = key % SIZE;
    if (values[i] == null) return false;
    return values[i].contains(key);
  }
}
