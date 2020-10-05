package linkedin._173_Binary_Search_Tree_Iterator;

/**
 * @author jacka
 * @version 1.0 on 10/21/2017.
 */
public interface BSTIterator {


  /**
   * @return whether we have a next smallest number
   */
  boolean hasNext();

  /**
   * @return the next smallest number
   */
  int next();
}
