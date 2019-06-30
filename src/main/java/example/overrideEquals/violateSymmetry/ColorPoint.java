package example.overrideEquals.violateSymmetry;

/**
 * @author jacka
 * @version 1.0 on 6/29/2019
 */
public class ColorPoint extends Point {
  private final Color color;

  public ColorPoint(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ColorPoint)) {
      return false;
    }
    // Broken: violate symmetry
    ColorPoint that = (ColorPoint) o;
    return super.equals(that) && that.color == color;
  }
}
