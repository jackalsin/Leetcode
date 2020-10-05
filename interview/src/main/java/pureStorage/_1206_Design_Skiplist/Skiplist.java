package pureStorage._1206_Design_Skiplist;

/**
 * @author jacka
 * @version 1.0 on 10/8/2019
 */
public interface Skiplist {

  boolean search(int target);

  void add(int num);

  boolean erase(int num);
}
