package _0251_0300._251_Flatten_2D_Vector;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 8/24/2017.
 */
public class Vector2DStephen implements Iterator<Integer> {
  private Iterator<List<Integer>> listIterator;
  private Iterator<Integer> childItr;

  public Vector2DStephen(List<List<Integer>> vec2d) {
    listIterator = vec2d.iterator();
  }

  @Override
  public Integer next() {
    hasNext();
    return childItr.next();
  }

  @Override
  public boolean hasNext() {
    while ((childItr == null || !childItr.hasNext()) && listIterator.hasNext()) {
      childItr = listIterator.next().iterator();
    }
    return childItr != null && childItr.hasNext();
  }

  public static void main(String[] args) {
    Iterator<Integer> itr = new ArrayList<Integer>().iterator();
    System.out.println(itr);
  }
}
