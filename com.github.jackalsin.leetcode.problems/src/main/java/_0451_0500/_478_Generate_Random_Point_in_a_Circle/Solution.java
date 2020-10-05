package _0451_0500._478_Generate_Random_Point_in_a_Circle;

import java.util.Random;

/**
 * @author jacka
 * @version 1.0 on 1/27/2019.
 */
public final class Solution {
  private final double radius, x, y;
  private final Random rand = new Random();

  public Solution(double radius, double x_center, double y_center) {
    this.radius = radius;
    this.x = x_center;
    this.y = y_center;
  }

  public double[] randPoint() {
    final double len = radius * Math.sqrt(rand.nextDouble()), deg = 2 * Math.PI * rand.nextDouble();
    return new double[]{x + len * Math.sin(deg), y + len * Math.cos(deg)};
  }

}
