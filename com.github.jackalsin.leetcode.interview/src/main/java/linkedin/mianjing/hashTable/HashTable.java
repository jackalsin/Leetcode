package linkedin.mianjing.hashTable;

import java.util.*;

public final class HashTable<T> implements Set<T> {
  private final List<List<T>> vals = new ArrayList<>();
  private final int size;
  private static final int DEFAULT_SIZE = 10;

  public HashTable() {
    size = DEFAULT_SIZE;
    for (int i = 0; i < size; ++i) {
      vals.add(new ArrayList<>());
    }
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public boolean contains(Object o) {
    final int hashcode = o.hashCode(), index = hashcode % size;
    synchronized (vals.get(index)) {
      final List<T> possible = vals.get(index);
      for (T p : possible) {
        if (p.equals(o)) {
          return true;
        }
      }
    }
    return false;
  }


  @Override
  public boolean add(T t) {
    final int hashcode = t.hashCode(), index = hashcode % size;
    synchronized (vals.get(index)) {
      final List<T> possible = vals.get(index);
      for (T p : possible) {
        if (p.equals(t)) {
          return false;
        }
      }
      vals.get(index).add(t);
    }
    return true;
  }

  @Override
  public boolean remove(Object o) {
    final int hashcode = o.hashCode(), index = hashcode % size;
    synchronized (vals.get(index)) {
      final List<T> possible = vals.get(index);
      for (T p : possible) {
        if (p.equals(o)) {
          possible.remove(o);
          return true;
        }
      }
    } // end of sync
    return false;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public <T1> T1[] toArray(T1[] a) {
    return null;
  }


  @Override
  public boolean containsAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean addAll(Collection<? extends T> c) {
    return false;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return false;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return false;
  }

  @Override
  public void clear() {

  }

}
