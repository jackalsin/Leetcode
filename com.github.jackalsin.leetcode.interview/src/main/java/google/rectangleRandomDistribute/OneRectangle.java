package google.rectangleRandomDistribute;

import java.util.Random;

import utils.Point;

/**
 * @author jacka
 * @version 1.0 on 3/1/2018.
 */
public final class OneRectangle implements Solution {
  private final int[] rectangle;
  private final Random random = new Random();

  /**
   * @param rectangle an array indicates the length and height
   */
  public OneRectangle(final int[] rectangle) {
    this.rectangle = rectangle;
  }

  @Override
  public Point getPoint() {
    return new Point(random.nextInt(rectangle[0]), random.nextInt(rectangle[1]));
  }

}
