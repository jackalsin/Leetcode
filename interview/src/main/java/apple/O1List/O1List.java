package apple.O1List;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 2/20/2021
 */
public interface O1List<E> {
  void addLast(E e);

  /**
   * delete某个元素第一次出现的位置
   */
  void delete(E e);

  boolean contains(E e);

  List<E> toList();

  void printList();
}
